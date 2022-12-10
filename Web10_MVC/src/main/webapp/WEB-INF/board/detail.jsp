<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>${vo.boardTitle }</title>
</head>
<body>
   <h2>글 보기</h2>
   <div>
      <p>글 번호 : ${vo.boardId }</p>
   </div>
   <div>
      <p>제목 : </p>
      <p>${vo.boardTitle }</p>
   </div>
   <div>
      <p>작성자 : ${vo.memberId }</p>
      <p>작성일 : ${vo.boardDateCreated }</p>
   </div>
   <div>
      <textarea rows="20" cols="120" readonly>${vo.boardContent }</textarea>
   </div>
   <a href="index.jsp"><input type="button" value="글 목록"></a>
   <a href="update.do?boardId=${vo.boardId }"><input type="button" value="글 수정"></a>
   <form action="delete.do" method="POST"><input type="hidden" name="boardId" value="${vo.boardId }">
      <input type="submit" value="글 삭제">
   </form>   
   
   <hr>
      
   <c:if test="${empty sessionScope.memberId }">
  		* 로그인부터 하고 온나.
   <a href="login.go">login</a>   
   </c:if>
      
   <input type="hidden" id="boardId" value="${vo.boardId }">
   <c:if test="${not empty sessionScope.memberId }">   
      ${sessionScope.memberId }야, 댓글허락해줌.
   		<div style="text-align: center;">
      		<input type="hidden" id="memberId" value="${sessionScope.memberId }">
     		<input type="text" id="replyContent">
      		<button id="btn_add">작성</button>
   		</div>
   
   </c:if>
      
      
   <hr>
   <div style="text-align: center;">
      <div id="replies"></div>
   </div>
   <div>
      <br><br><br><br><br><br><br><br><br><br><br><br><br>
   </div>
   
   <script type="text/javascript">
      $(document).ready(function(){
         getAllReplies();
         
         $('#btn_add').click(function(){
            var boardId = $('#boardId').val(); // 게시판 번호 데이터
            var memberId = $('#memberId').val(); // 작성자 데이터
            var replyContent = $('#replyContent').val(); // 댓글 내용
            var obj = {
                  'boardId' : boardId,
                  'memberId' : memberId,
                  'replyContent' : replyContent
            };
            console.log(obj);
            
            // $.ajax로 송수신
            $.ajax({
               type : 'POST', 
               url : 'replies/add',
               data : {'obj' : JSON.stringify(obj)}, // JSON으로 변환
               success : function(result) {
                  console.log(result);
                  if(result == 'success') {
                     alert('댓글 입력 성공');
                     getAllReplies();
                  }
               }
            }); // end ajax()
            
         }); // end btn_add.click()
         
         // 게시판 댓글 전체 가져오기
         function getAllReplies() {
            var boardId = $('#boardId').val();
            
            var url = 'replies/all?boardId=' + boardId;
            
            $.getJSON(
               url, 
               function(data) {
            	   // data : 서버에서 온 list 데이터가 저장되어 있음
            	   // getJSON()에서 json데이터는 자동으로 parsing            	   
                  console.log(data);
                  
         		// 로그인 한 사용자 아디 값?
         		var memberId = $('#memberId').val();
         		         		
               	var list = ''; // 댓글 데이터를 HTML에 표현할 문자열 변수
               	                	  
      			  // $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
                $(data).each(function(){
                	// this : 컬렉션의 (한 줄)raw 데이터
                  console.log(this);
                  
                  var replyDateCreated = new Date(this.replyDateCreated);
                  
                  var disabled = 'disabled';
                  var readonly = 'readonly';

					// 같으면 disabled를 없앤다!
                  if(memberId == this.memberId){
                	  disabled = '';
                	  readonly = '';
                  }
                  	                 	
                  	list += '<div class="reply_item">'
                  	 	+ '<pre>'
                  	 	+ '<input type="hidden" id="replyId" value="'+ this.replyId +'"/>'
                  	 	+ '<input type="hidden" id="memberId" value="'+ this.memberId +'"/>'
                  	 	+ this.memberId
                  	 	+ '&nbsp;&nbsp;' // 공백
                  	 	+ '<input type="text" ' + readonly + ' id="replyContent" value=" '+ this.replyContent + '" />'
                  		+ '&nbsp;&nbsp;' // space
                  		+ replyDateCreated
                  		+ '&nbsp;&nbsp;'
                  		+ '<button class="btn_update" ' + disabled +'>update</button>'
                  		+ '<button class="btn_delete" ' + disabled +'>delete</button>'                  		
                  	 	+ '</pre>'
                  	 	+ '</div>';
                  	 	
                  });
      			  $('#replies').html(list);
               }
            ); // end getJSON()
        } // end getAllReplies()         
         
        // 수정 버튼 클릭하면 선택된 댓글 수정
        // 리플라이 밑 클릭 업데이트 이벤트를 주겠다 
        $('#replies').on('click', '.reply_item .btn_update', function(){
        	console.log(this); // 이해안될 때 무조건 로그 ㄱㄱ
        
        	// 선택된 댓글의 replyId, replyContent 값 저장, 띄워쓰기가 밑 개념
        	// prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
        	var replyId = $(this).prevAll('#replyId').val();
        	var replyContent = $(this).prevAll('#replyContent').val();
        	console.log("replyId : " + replyId + ", replyContent : " + replyContent);
        	
        	// $(this).prevAll('#replyContent').prop("readonly", "readonly"); 
        	
        	// ajax 요청
        	$.ajax({
        		type : 'POST',
        		url : 'replies/update',
        		data : {
        			'replyId' : replyId,
        			'replyContent' : replyContent        			
        		},
        		success : function(result) {
        			console.log(result);
        			if(result == 'success') {
        				alert('update success!');
        				getAllReplies(); // 시점적으로 접근해, 
        			}        			
        		}
        		
        	});//end ajax
        	            	
      	});//end relplies.on()
      	
      	// delete
      	$('#replies').on('click', '.reply_item .btn_delete', function(){
        	console.log(this);
        	
        	var replyId = $(this).prevAll('#replyId').val();
			console.log("선택된 댓글 번호 : " + replyId);
			
			// ajax 요청
			$.ajax({
				type : 'POST',
				url : 'replies/delete',
				data : {
					'replyId' : replyId
				},
				success : function(result) {
					if(result == 'success') {
						alert('댓글 삭제 성공!');
						getAllReplies();
					}
				}
			}); // end ajax()
			       	
      	});//end replies.on()delete
      	                         
      }); // end document
   </script>
</body>
</html>
