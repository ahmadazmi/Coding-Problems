class BrowserHistory {
    String[] map;
    int position;
    int len;

    public BrowserHistory(String homepage) {
        map = new String[5000];
        map[len = position = 0] = homepage;
    }
    
    public void visit(String url) {
        map[len = ++position] = url;
    }
    
    public String back(int steps) {
        return map[position = Math.max(0, position - steps)];
    }
    
    public String forward(int steps) {
        return map[position = Math.min(len, position + steps)];
    }
}