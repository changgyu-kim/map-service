<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<!--  Body Wrapper -->
<div>
    <input id="search" class="form-control mr-sm-2" name="keyword" type="search" placeholder="Search" aria-label="Search">
    <button id="searchBtn" class="btn btn-outline-success my-2 my-sm-0" type="button">Search</button>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
        </tr>
        </thead>
        <tbody id="list" class="table-group-divider">
        </tbody>
    </table>
    <div id="pageNav"></div>
    <div>
        <a href="/ui-notice/write" class="btn btn-outline-success my-2 my-sm-0"  type="button">Write</a>
    </div>

</div>
</html>
<script>
    $(document).ready(function () {
        search(1);

        $('#searchBtn').click(function (){
            search(1);
        })
    });

    function search(curpage) {
        let keyword = $('#search').val();
        $.ajax({
            type: "GET",
                url: `/notices?curPage=${curpage}&keyword=${keyword}`,
                    success: function (response) {
                    let html = "";
                    response.content.forEach(notice => {
                        html += "<tr>";
                        html += `<td>${notice.id}</td>`;
                        html += `<td><a href="/ui-notice/${notice.id}">${notice.title}</a></td>`;
                        html += `<td>${notice.userId}</td>`;
                        html += "<tr>";
                    });
                    $('#list').empty().append(html); // empty()를 해야 앞에 불러온 데이터를 비우고 현재 값을 추가한다

                $('#pageNav').paging({
                    pageSize: response.numberOfElements,
                    currentPage: curpage, // 내가 클릭한 페이징 번호
                    pageTotal: response.totalElements,
                });
            },
            error: function (error) {
                console.error("error : ", error);
            }
        });
    };

    function goPage(curPage) {
        search(curPage);
    }
</script>