package Assignments;

class IRUtil {
	public static int getFrequencyCount(String term,String doc) {
		term.toLowerCase();
		doc.toLowerCase();
		int freqCount = 0;
		for(int idx = 0;idx<doc.length()-term.length();idx++) {
			String s = doc.substring(idx,idx+term.length());
			if(term.equals(s)) {
				freqCount++;
			}
		}
		
		return freqCount;
	}
	public static double termFrequency(String term,String doc) {
		double frequencyCount = getFrequencyCount(term, doc);
		double totalCount = doc.split(" ").length;
		//System.out.println("FreqCount: "+frequencyCount);
		//System.out.println("TotalCount: "+ totalCount);
		return frequencyCount/totalCount;
	}
	public static void main(String[] args) {
		double tf = termFrequency("java","java python c++ java python c pascal java perl");
		
		System.out.println("TF: "+tf);
	}
}
