class TextEditor {
    private Stack<Character> leftStack;
    private Stack<Character> rightStack;

    public TextEditor() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }
    
    public void addText(String text) {
        for (char c : text.toCharArray()) {
            leftStack.push(c);
        }
    }
    
    public int deleteText(int k) {
        int deleted = 0;
        while (k > 0 && !leftStack.isEmpty()) {
            leftStack.pop();
            deleted++;
            k--;
        }
        return deleted;
    }
    
    public String cursorLeft(int k) {
        while (k > 0 && !leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
            k--;
        }
        return getLastTenChars();
    }
    
    public String cursorRight(int k) {
        while (k > 0 && !rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
            k--;
        }
        return getLastTenChars();
    }

    private String getLastTenChars() {
        StringBuilder sb = new StringBuilder();
        int limit = Math.min(leftStack.size(), 10);

        for (int i = leftStack.size() - limit; i < leftStack.size(); i++) {
            sb.append(leftStack.get(i));
        }
        return sb.toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */