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

.table-hover thead tr:hover th, .table-hover tbody tr:hover td {
    background-color:  #f4f4ff;
}

</style>
</head>
<body>
<div class="container-fluid">
	<c:import url="/WEB-INF/views/franchisee/fr_header.jsp"/>
	
     <div class="row" style="margin-top:20px;">
        	<!-- 콘텐츠 영역 (가맹점 정산내역조회)-->
       <div class="container-fluid pb-3" id="content-area"style="max-width: 100%;">
       <div class="d-grid gap-3" style="grid-template-columns: 0.5fr 0.8fr 0.5fr">
          <div class="bg-body-tertiary border rounded-3" style="visibility: hidden;">
            <br />
          </div>
          
          <button type="button" class="btn btn-dark">기간</button>
        <!-- 정산내역 테이블 -->
        <table class="table table-hover">
        

		  <thead>
		    <tr>
		      <th scope="col">정산일자</th>
		      <th scope="col">정산기간</th>
		      <th scope="col">입금금액</th>
		      <th scope="col">상태</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">21.03.05</th>
		      <td>21.03.19 ~ 21.03.21</td>
		      <td>3,150,000원</td>
		      <td>입금완료</td>
		    </tr>
		    <tr>
		      <th scope="row">21.03.09</th>
		      <td>21.03.19 ~ 21.03.21</td>
		      <td>4,130,000원</td>
		      <td>만나서 결제</td>
		    </tr>
		    <tr>
		      <th scope="row">3</th>
		      <td colspan="2">Larry the Bird</td>
		      <td>@twitter</td>
		    </tr>
		  </tbody>
		</table>
        
        
      
      </div>
      </div>
    </div>
    </div>
<%-- <c:import url="/WEB-INF/views/common/footer.jsp" /> --%>
</body>
</html>