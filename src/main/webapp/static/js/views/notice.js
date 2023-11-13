$(document).ready(function () {
    search(1);
    paging(1);
    $('#searchBtn').click(function () {
        search(1);
        paging(1);
    })
});

function search(curpage) {
    let keyword = $('#keywordSearch').val();
    $.ajax({
        type: "GET",
        url: `/notices?curPage=${curpage}&keyword=${keyword}`,
        success: function (response) {
            let html = "";
            for (const notice of response.data) {
                html += `<tr>
                        <td> ${notice.id} </td>
                        <td><a href="/notice-detail/${notice.id}">${notice.title}</a></td>
                        <td>${notice.writer}</td>
                    </tr>`;
            }

            $('#list').empty().append(html); // empty()를 해야 앞에 불러온 데이터를 비우고 현재 값을 추가한다

        },
        error: function (error) {
            console.error("error : ", error);
        }
    });
};

function paging(curpage){
    let keyword = $('#keywordSearch').val();
    $.ajax({
        type: "GET",
        url: `/paging?curPage=${curpage}&keyword=${keyword}`,
        success: function (response) {
            let pageNav  = "";
            <!-- 페이징  -->
            $('#pageNav').paging({
                pageSize: response.data.pageSize,
                currentPage: response.data.curPage, // 내가 클릭한 페이징 번호
                pageTotal: response.data.totalCnt,
            });

        },
        error: function (error) {
            console.error("error : ", error);
        }
    });
}

function goPage(curPage) {
    search(curPage);
    paging(curPage);

}
