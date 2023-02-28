package com.semanticsquare.thrillio.bgjobs;

import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.WebLink;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WebPageDownloaderTask implements Runnable{
    private boolean downloadAll = false;
    private static BookmarkDao bookmarkDao = new BookmarkDao();
    private static final long TIME_FRAME = 3L;

    public WebPageDownloaderTask(boolean downloadAll) {
        this.downloadAll = downloadAll;
    }
    ExecutorService downloadExecutor = Executors.newFixedThreadPool(5);

    private static class Downloader<T extends WebLink> implements Callable<T> {
        private T weblink;
        public Downloader(T weblink) {
            this.weblink = weblink;
        }
        public T call() {
            try {
                if(weblink.getUrl().endsWith(".pdf")){
                    weblink.setDownloadStatus(WebLink.DownloadStatus.NOT_ELIGIBLE);
                    System.out.println("Weblink is pdf");
                }
                else {
                    weblink.setDownloadStatus(WebLink.DownloadStatus.FAILED);
                    String htmlPage = HttpConnect.download(weblink.getUrl());
                    weblink.setHtmlPage(htmlPage);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return weblink;
        }
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            List<WebLink> webLinks = getWebLinks();
//            System.out.println(webLinks);
            if(webLinks.size()>0){
                download(webLinks);
            }
            else {
                System.out.println("No New WebLinks Available");
            }

            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        downloadExecutor.shutdown();
    }

    private void download(List<WebLink> webLinks) {
        List<Downloader<WebLink>> tasks = getTasks(webLinks);
        List<Future<WebLink>> futures = new ArrayList<>();

        try {
            futures = downloadExecutor.invokeAll(tasks,TIME_FRAME, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Future<WebLink> future : futures) {
            try {
                if (!future.isCancelled()) {
                    WebLink webLink = future.get();
                    String webPage = webLink.getHtmlPage();
//                    System.out.println(webPage);
                    if(webPage!=null){
                        IOUtil.write(webPage,webLink.getId());
                        webLink.setDownloadStatus(WebLink.DownloadStatus.SUCCESS);

                        System.out.println("Download Success "+ webLink.getUrl());
                    }
                    else{
                        System.out.println("Webpage Not Downloaded " + webLink.getUrl());
                    }
                } else {
                    System.out.println("\n\nTask is cancelled --> " + Thread.currentThread());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


    }

    private List<Downloader<WebLink>> getTasks(List<WebLink> webLinks) {
        List<Downloader<WebLink>> tasks = new ArrayList<>();
        for(WebLink webLink:webLinks){
            tasks.add(new Downloader<WebLink>(webLink));
        }
        return tasks;
    }

    private List<WebLink> getWebLinks() {
        List<WebLink> webLinks = null;
        if(downloadAll){
            webLinks = bookmarkDao.getAllWeblinks();
            downloadAll = false;
        }else{
            webLinks = bookmarkDao.getWebLinks(WebLink.DownloadStatus.NOT_ATTEMPTED);
        }
        return webLinks;
    }

}
