
public int countOfMaxWords {

		String string="The capital of India is Delhi. Where is Mumbai located ? it's in Maharashtra !";
		String[] strings=string.split("\\.|\\!|\\?");
		System.out.println(strings.length);
		String[] words;
		int max=0;
		for(int i=0;i<strings.length;i++){
			words=strings[i].split(" ");
			if(max<words.length)
				max=words.length;
		}
	return max;

}
