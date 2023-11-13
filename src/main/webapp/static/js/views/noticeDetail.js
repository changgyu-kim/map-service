let id = $('#id').val();
$(document).ready(function () {
    getNotice(id);

    $('#backBtn').click(function () {
// js에서 지원하는 뒤로가는 함수
        history.back();
    });
    $('#deleteBtn').click(function () {
// js에서 지원하는 뒤로가는 함수
        deleteNotice();
    });
});

function getNotice(id) {
    console.log("id : ", id);
    $.ajax({
        type: "GET",
        url: `/notice/${id}`,
        success: function (response) {

            console.log("response : ", response);
            let html = "";
            html += `<div class="form-group">
                        <label for="id">번호</label>
                        <input type="text"  name="id" class="form-control" id="id"  value="${response.data.id}" disabled  >
                  </div>
                      <div class="form-group">
                        <label for="title">제목</label>
                        <input type="text"  name="title" class="form-control" id="title" value="${response.data.title}" disabled>
                  </div>
                  <div class="form-group" >
                        <label for="content">본문</label>
                        <textarea class="form-control"  name="content" id="content" rows="3" disabled>${response.data.content}</textarea>
                  </div>`
            ;
            $('#info').empty().append(html); // empty()를 해야 앞에 불러온 데이터를 비우고 현재 값을 추가한다

        },
        error: function (error) {
            console.error("error : ", error);
            alert("에러입니다.")
        }
    });
}

function deleteNotice() {
    $.ajax({
        type: "DELETE",
        url: `/notice/${id}`,
        success: function (response) {
            alert("삭제가 완료되었습니다.")
            location.href = "/notice"
        },
        error: function (error) {
            console.error("error : ", error);
            alert("에러입니다.")
        }
    });
}
