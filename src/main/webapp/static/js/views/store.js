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
        url: `/storeList?curPage=${curpage}&keyword=${keyword}`,
        success: function (response) {
            let html = "";
            for (const store of response.data) {
                html += `<tr>
                        <td> ${store.id} </td>
                        <td>${store.sort}</a></td>
                        <td>${store.name}</td>
                        <td>${store.mainMenu}</td>
                        <td>${store.price}</td>
                        <td>${store.phone}</td>
                        <td>${store.address}</td>
                    </tr>`;
            }
            $('#list').empty().append(html);
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
        url: `/store-paging?curPage=${curpage}&keyword=${keyword}`,
        success: function (response) {
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
