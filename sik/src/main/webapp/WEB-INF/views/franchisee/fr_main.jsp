<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>식플루언서</title>
<style>
.content-area {
  display: flex;
  justify-content: center;
}
</style>

<script type="text/javascript">
$(function(){
	//브랜드 공지사항 상세보기 
	$.ajax({
		url: "brandNoticeListView.do",
		type:"post",
		dataType:"json",
		success: function(data) {
			console.log("success(가맹메인-브랜드공지) : " + data);
		
			var str = JSON.stringfy(data);
			
			var json = JSON.parse(str);
			
			values = "";
			for(var i in json.list){
				values += "<tr><td>" + json.list[i].no
				+ "</td><td><a href ='' "
				+ json.list[i].no + "'>"
				+decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") 
				 + "</a></td><td>"
                 + json.list[i].date + "</td></tr>";
			}
			
		}
	})
});


</script>
</head>
<body>
<div class="container-fluid">
	<c:import url="/WEB-INF/views/franchisee/fr_header.jsp"/>
	
     <div class="row" style="margin-top:20px;">
        	<!-- 콘텐츠 영역 -->
       <div class="container-fluid pb-3" id="content-area"style="max-width: 100%;">
       <div class="d-grid gap-3" style="grid-template-columns: 0.3fr 0.7fr 0.1fr 0.3fr">
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
          
          	<!-- 공지사항 -->
          <div class="bg-body-tertiary border rounded-3">
          	<c:import url="/WEB-INF/views/main/notice.jsp"/>
          
          </div>
          <!-- 공지사항 -->
                              
        <!-- 달력 -->
       <!--  <div class="d-grid gap-4" style="grid-template-columns: 0.5fr 0.5fr 0.5fr"> -->
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
           
          </div>
			<c:import url="/WEB-INF/views/main/calenda.jsp"/>
		<!-- 달력 -->
            <Br>
	<!-- 두번째 줄 -->
		 <div class="container-fluid pb-3" id="content-area"style="max-width: 100%;">
       <div class="d-grid gap-3" style="grid-template-columns: 0.3fr 0.7fr 0.1fr 0.3fr">
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
	
            <br />
          </div>
        </div>
                <!-- 달력 -->
      <!--  <div class="d-grid gap-4" style="grid-template-columns: 0.5fr 0.3fr 0.5fr 0.5fr"> -->
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
			<c:import url="/WEB-INF/views/main/calenda.jsp"/>
		<!-- 달력 -->
       
        <br>
      
        
          <!-- 주문/결제 내역 -->
          <div class="bg-body-tertiary border rounded-3">
          	<c:import url="/WEB-INF/views/franchisee/fr_orderpay/fr_orderpay.jsp"/>
          </div>
          
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
           
          </div>
       
        <!-- 주문/결제 내역 -->
        
     </div> 
       </div>
      </div>
      </div>
    </div>
<%-- <c:import url="/WEB-INF/views/common/footer.jsp" /> --%>
</body>
</html>