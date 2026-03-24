<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>기업정보페이지 등록</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main/mypage/mypage-company-reg-jobposting.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/main/mypage/mypage-company-reg-jobposting.js"></script>
</head>

<body>
	<c:set var="isLoggedIn"
		value="${not empty sessionScope.user or not empty sessionScope.userNumber}" />
	<c:set var="defaultCompanyImg"
		value="${pageContext.request.contextPath}/assets/img/기업이미지_샘플1.jpg" />

	<c:choose>
		<c:when test="${not empty sessionScope.userNumber}">
			<c:choose>
				<c:when test="${sessionScope.userType == '기업회원'}">
					<jsp:include page="/app/main/header/header-login-company.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="/app/main/header/header-login-member.jsp" />
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<jsp:include page="/app/main/header/header-logout.jsp" />
		</c:otherwise>
	</c:choose>
	<main>
		<div class="jobpost-main-container">
			<div class="jobpost-title">마이페이지</div>
			<div class="jobpost-subtitle">기업정보 등록</div>

			<form id="company-register-form"
				action="${pageContext.request.contextPath}/company/mypage/companypageRegisterOk.mpfc"
				method="post" enctype="multipart/form-data">

				<!-- 기업 기본정보 -->
				<div class="jobpost-section">
					<div class="jobpost-section-title">기업 기본정보</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">기업 프로필 이미지</div>
						<div class="jobpost-section-content">
							<input class="jobpost-section-inputcontent" type="file"
								name="company_profile_img" id="company-profile-img"
								accept="image/*" required>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							대표자명 <span class="limit-text">(최대 20자)</span>
						</div>
						<div class="jobpost-section-content">
							<input class="jobpost-section-inputcontent" type="text"
								name="company_ceoname" id="company-ceoname"
								placeholder="예 : 홍길동" maxlength="20" required>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							설립년도 <span class="limit-text">(최대 4자)</span>
						</div>
						<div class="jobpost-section-content">
							<input class="jobpost-section-inputcontent" type="text"
								name="company_yearfounded" id="company-yearfounded"
								placeholder="예 : 2010" maxlength="4" required>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							사원수 <span class="limit-text">(최대 20자)</span>
						</div>
						<div class="jobpost-section-content">
							<input class="jobpost-section-inputcontent" type="text"
								name="company_employeecount" id="company-employeecount"
								placeholder="예 : 1200명" maxlength="20" required>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							매출액 <span class="limit-text">(최대 20자)</span>
						</div>
						<div class="jobpost-section-content">
							<input class="jobpost-section-inputcontent" type="text"
								name="company_sales" id="company-sales"
								placeholder="예 : 100,000,000원" maxlength="20" required>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							자본금 <span class="limit-text">(최대 20자)</span>
						</div>
						<div class="jobpost-section-content">
							<input class="jobpost-section-inputcontent" type="text"
								name="company_capital" id="company-capital"
								placeholder="예 : 100,000,000원" maxlength="20" required>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							기업형태 <span class="limit-text">(최대 20자)</span>
						</div>
						<div class="jobpost-section-content">
							<input class="jobpost-section-inputcontent" type="text"
								name="company_type" id="company-type" placeholder="예 : 중견기업"
								maxlength="20" required>
						</div>
					</div>
				</div>

				<!-- 기업 정보 -->
				<div class="jobpost-section">
					<div class="jobpost-section-title">기업 정보</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							한줄소개 <span class="limit-text">(최대 50자)</span>
						</div>
						<div class="jobpost-section-content">
							<input class="jobpost-section-inputcontent" type="text"
								name="company_description" id="company-description"
								placeholder="예 : 보안서비스 개발 컨설팅 전문기업" maxlength="50" required>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							기업정보 <span class="limit-text">(최대 1000자)</span>
						</div>
						<div class="jobpost-section-content-textarea">
							<textarea name="company_info" id="company-info"
								placeholder="기업의 상세 소개를 입력하세요" maxlength="1000" required></textarea>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							대표기술 <span class="limit-text">(최대 500자)</span>
						</div>
						<div class="jobpost-section-content-textarea">
							<textarea class="jobpost-section-content" name="company_tech"
								id="company-tech" placeholder="사용 기술, 보유 기술, 핵심 역량 등을 입력하세요"
								maxlength="500" required></textarea>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							주요사업 <span class="limit-text">(최대 700자)</span>
						</div>
						<div class="jobpost-section-content-textarea">
							<textarea name="company_business" id="company-business"
								placeholder="주요 서비스, 사업 분야 등을 입력하세요" maxlength="700" required></textarea>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							서비스 확장 및 운영 이력 <span class="limit-text">(최대 1000자)</span>
						</div>
						<div class="jobpost-section-content-textarea">
							<textarea name="company_history" id="company-history"
								placeholder="주요 서비스, 사업 분야 등을 입력하세요" maxlength="1000" required></textarea>
						</div>
					</div>
				</div>

				<!-- 채용공고 -->
				<div class="jobpost-section">
					<div class="jobpost-section-title">채용공고</div>

					<div class="jobpost-section-jobchecklist">
						직군선택
						<div class="check-item">
							<c:forEach var="jobGroup" items="${jobGroupList}">
								<label> <input type="checkbox" name="job_group"
									value="${jobGroup.jobNumber}"> <span>${jobGroup.jobName}</span>
								</label>
							</c:forEach>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							인재상 <span class="limit-text">(최대 500자)</span>
						</div>
						<div class="jobpost-section-content-textarea">
							<textarea name="company_talent" id="company-talent"
								maxlength="500" required></textarea>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							채용부분 <span class="limit-text">(최대 1000자)</span>
						</div>
						<div class="jobpost-section-content-textarea">
							<textarea name="company_jobpart" id="company-jobpart"
								maxlength="1000" required></textarea>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							채용 절차 <span class="limit-text">(최대 500자)</span>
						</div>
						<div class="jobpost-section-content-textarea">
							<textarea name="company_process" id="company-process"
								maxlength="500" required></textarea>
						</div>
					</div>

					<div class="jobpost-section-box">
						<div class="jobpost-section-subtitle">
							지원 정보 <span class="limit-text">(최대 500자)</span>
						</div>
						<div class="jobpost-section-content-textarea">
							<textarea name="company_apply" id="company-apply" maxlength="500"
								required></textarea>
						</div>
					</div>
				</div>

				<div class="btn-wrap">
					<button type="submit" class="btn" id="save-btn">입력완료</button>
					<button type="button" class="btn" id="cancel-btn"
						data-move-url="${pageContext.request.contextPath}/company/mypage.mpfc">취소</button>
				</div>
			</form>
		</div>
	</main>
	<footer><jsp:include page="/app/main/footer/footer.jsp" /></footer>
</body>

</html>