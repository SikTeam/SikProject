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
//브랜드 공지사항 상세보기 
/* function frBrandNotice () {
	$.ajax({
		url: 'frbrandnotice.do',
		type: 'post',
		data: {
			keyword : $('#keyword').val()
		},
		dataType: "json",
		success: function(dataObj) {
			console.log('dataObj :' + dataObj);
			
			var objStr = JSON.stringify(dataObj);
			var jsonObj = JSON.parse(objStr);
			
			var output ="";
			
			for(var i in jsonObj.list) {
				output += "<tr><td>" + jsonObj.list[i].brandnoticewriter + "</td>"
				+"<td>"+
			}
		}
		
	}); //ajax
	
} */
	

	
	


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
          	<h1 align="center">${ listCount }개의브랜드 list</h1>
			<hr>
		<%-- <table align="center" width="500" border="1" cellspacing="0"
		cellpadding="0">
		<tr>
			<th align="center">브랜드ID</th>
			<th align="center">브랜드 이름</th>
			<th align="center">생성일</th>
			<th align="center">수정일</th>
			<th align="center">활성화 여부</th>
		</tr>

		<c:forEach items="${ requestScope.list }" var="n">
			<tr>
				<td align="center">${ n.brandId }</td>
				<td>${ n.brandName }</td>
				<td align="center"><fmt:formatDate value="${ n.brandBir }"
						pattern="yyyy-MM-dd" /></td>
				<td align="center"><fmt:formatDate value="${ n.brandUp }"
						pattern="yyyy-MM-dd" /></td>
				<td align="center">${ n.brandYn }</td>
			</tr>
		</c:forEach>
	</table> --%>
          
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