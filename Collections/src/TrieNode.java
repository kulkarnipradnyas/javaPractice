import java.util.LinkedList;

 class TrieNode {

	public char data;
	boolean isEnd;
	int count;
	LinkedList<TrieNode> childList;

	TrieNode(char c) {
		childList = new LinkedList<TrieNode>();
		data = c;
		isEnd = false;
		count = 0;
	}
	public TrieNode getCildNode(char c) {
		 if (childList != null)
	            for (TrieNode eachChild : childList)
	                if (eachChild.data == c)
	                    return eachChild;
	        return null;
		
	}
	

}
