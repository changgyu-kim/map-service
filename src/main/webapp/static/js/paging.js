(function ($){
    // $.paging() 으로 html에서 호출할 수 있다.
   $.fn.paging = function(options){

       // ex) notice.html 에서 $('pageNav')가 이 함수를 호출했으면 호출한 선택자로 curThis값을 초기화 한다는 것
       let curThis = this;
       let defaults = {
           currentPage: 1, // 보여줄 현재페이지
           pageSize:2, // 한 페이지 당 몇개 보여줄 지
           pageTotal: 0, // 총 데이터 수
           pageBlock: 10, // 1~10 단위로 페이징을 끊어서 보여줌
       };

       // $.extend()란 두개의 객체를 하나로 합치는 것
       // 받아온 options의 키값이 default키값과 같으면 덮어쓰고 겹치는 키값이 없으면 추가됨
       let subOption = $.extend(true, defaults, options)

       // 현재 매개변수로 가져오지 않는 goPageFnName을 null로 주고 값을 바꿀 수 있도록 하는 이유는
       // 페이징을 구현할 메서드 이름을 바꿀 수 있다. (ex. goPage -> gogoPage)
       let goPageFnName = null;
       if(subOption.goPageFnName === undefined || subOption.goPageFnName === null || subOption.goPageFnName === ''){
           goPageFnName = "goPage";
       } else {
           goPageFnName = subOption.goPageFnName;
       }

       // each는 jqeury의 forEach 문법이다.
       return this.each(function(){
           // *1 을 해주면 실수를 정수로 바꿔주기 때문에 적용
           let currentPage = subOption.currentPage*1;
           let pageSize = subOption.pageSize*1;
           let pageTotal = subOption.pageTotal*1;
           let pageBlock = subOption.pageBlock*1;

           // JPA를 사용하지 않는 환경일 경우에만 사용
           // (비동기로 페이징 구현 시 JPA가 알아서 컨트롤러로 현재 보여주여야 할 페이지 등을 전달해주는데, 비동기일 경우 그게 안됨)
           // 총 페이지 갯수 (전체데이터 / 현재페이지 몇개보여주고 있는지)
           let pageTotalCnt = Math.ceil(pageTotal / pageSize);
           // 몇개의 블럭이 생기는 지(ex. 1~10, 11~29 면 2블럭이 생김) (현재페이지 번호 / 몇개단위로 페이징을 하고있는지 갯수)
           let pageBlockCnt = Math.ceil(currentPage / pageBlock)
           // 시작페이지와 끝 페이지값을 담을 변수
           let startPage, endPage;
           // 동적 으로 html태그를 담을 변수
           let html = "";
            
           // 페이징블럭 갯수가 1보다 크면
           if(pageBlock > 1){
               // startPage 에 현재 보여지는 paging에서 맨 앞번호를 넣는다
               startPage = (pageBlockCnt - 1) * pageBlock + 1;
           }

           // 페이징 블럭 갯수 * 페이징블럭 이 전체 페이지갯수 보다 크거나 같다면 
           if( (pageBlockCnt * pageBlock) >= pageTotalCnt){
               // 엔드 페이지는 전체 페이지 갯수랑 같고
                endPage = pageTotalCnt;
           } else {
               // 페이징 블럭 갯수 * 페이징블럭 이 전체 페이지갯수 보다 작다면
                // 엔드 페이지는 페이징 블럭 갯수 * 페이징블럭이 된다(ex. 1 ~ 10 페이징이 있으면 10의 값이 endPage에 들어감 )
                endPage = pageBlockCnt * pageBlock;
           }

           html += `<nav aria-label="Page navigation example">`;
           html +=      `<ul class="pagination">`

           if(startPage > 1){
               html +=          `<li class="page-item">`
               html +=              `<a class="page-link" onclick="${goPageFnName}(1)">`
               html +=                  `<span aria-hidden="true">&laquo;</span>`
               html +=              `</a>`
               html +=          `</li>`
           }

           for(let i = startPage; i <= endPage; i++){
               // 현재 페이지와 같은 페이징번호는 클릭이벤트 X
               if(currentPage === i){
                   html +=          `<li class="page-item" >`
                   html +=              `<a class="page-link" >${i}</a>`
                   html +=          `</li>`
               } else {
                   html +=          `<li class="page-item" >`           // 이거 함수처리 다시 확인해보기
                   html +=              `<a class="page-link" onclick="${goPageFnName}(${i});">${i}</a>`
                   html +=          `</li>`
               }
           }
            // endPage가 전체페이지갯수보다 작을때 >> 보이기
           if(endPage < pageTotalCnt){
               html +=          `<li class="page-item">`
               html +=              `<a class="page-link" onclick="${goPageFnName}(${endPage+1})" aria-label="Next">`
               html +=                  `<span aria-hidden="true">&raquo;</span>`
               html +=              `</a>`
               html +=          `</li>`
           }

           html +=      `</ul>`
           html += `</nav>`;
           // 예를들어 $('#pageNav').empty().append(html); 과 같다
           $(curThis).empty().append(html);
       })
   };
})(jQuery); // 함수를 호출하는 부분으로 jQuery 객체를 전달하여 현재함수를 jQuery로 사용할 수 있게 함