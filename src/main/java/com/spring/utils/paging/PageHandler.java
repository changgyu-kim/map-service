package com.spring.utils.paging;

public class PageHandler {
    private int totalCnt; // 전체 게시물 수
    private int pageSize; // 한 페이지의 크기
    private int naviSize = 5; // 네비게이션 바 크기(갯수)
    private int totalPage; // 전체 페이지 갯수
    private int curPage; // 현재 페이지
    private int beginPage; // 네비게이션의 첫번째 페이지
    private int endPage;   // 네비게이션의 마지막 페이지
    private boolean showPrev;  // 이전 페이지로 이동하는 링크를 보여 줄 것인지 여부("<")
    private boolean showNext;  // 다음 페이지로 이동하는 링크를 보여 줄 것인지 여부(">")



    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int page) {
        this.curPage = curPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public PageHandler(int totalCnt, int page){
        this(totalCnt, page, 5);
    }

    // 페이징 계산하는데 필요한 요소는 3가지 이다.
    public PageHandler(int totalCnt, Integer curPage, Integer pageSize){
        this.totalCnt = totalCnt;
        this.curPage = curPage;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt/(double)pageSize);

        beginPage = (((curPage-1)/naviSize)*5)+1;

        endPage = Math.min(beginPage + naviSize-1, totalPage);

        showPrev = (beginPage != 1);

        showNext = (endPage != totalPage);
    }

    public void print() {
        System.out.println("curPage = "+ curPage);
        System.out.println("totalPage = "+totalPage );
        System.out.println("beginPage = "+beginPage );
        System.out.println("endPage = "+endPage );
        System.out.print(showPrev ? "[PREV]" : "");
        for(int i=beginPage; i<=endPage; i++ ) {
            System.out.print(i+" ");
        }
        System.out.print(showNext ? "[NEXT]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler [totalCnt=" + totalCnt + ", pageSize=" + pageSize + ", naviSize=" + naviSize
                + ", totalPage=" + totalPage + ", curPage=" + curPage + ", beginPage=" + beginPage + ", endPage=" + endPage
                + ", showPrev=" + showPrev + ", showNext=" + showNext + "]";
    }





}
