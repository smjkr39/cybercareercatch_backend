<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
if (request.getAttribute("companyDetail") == null) {
	response.sendRedirect(request.getContextPath() + "/company/companyAd.cfc");
	return;
}
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CyberCareerCatch</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;600;700&family=Poppins:wght@400;500;600&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main/header/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main/company/company-info.css">
</head>

<body>

	<jsp:include page="/app/main/header/header-logout.jsp" />

	<c:set var="isLoggedIn"
		value="${not empty sessionScope.user or not empty sessionScope.memberNumber}" />
	<c:set var="qnaTargetUrl"
		value="${pageContext.request.contextPath}/member/login.mefc" />
	<c:set var="qnaLoginRequired" value="true" />

	<c:if test="${isLoggedIn}">
		<c:set var="qnaTargetUrl"
			value="${pageContext.request.contextPath}/qna/list.qfc" />
		<c:set var="qnaLoginRequired" value="false" />
	</c:if>

	<c:set var="logoSrc" value="" />
	<c:if test="${not empty companyDetail.filePath}">
		<c:choose>
			<c:when
				test="${fn:startsWith(companyDetail.filePath, 'http://') or fn:startsWith(companyDetail.filePath, 'https://')}">
				<c:set var="logoSrc" value="${companyDetail.filePath}" />
			</c:when>
			<c:when test="${fn:startsWith(companyDetail.filePath, '/')}">
				<c:set var="logoSrc"
					value="${pageContext.request.contextPath}${companyDetail.filePath}" />
			</c:when>
			<c:otherwise>
				<c:set var="logoSrc"
					value="${pageContext.request.contextPath}/${companyDetail.filePath}" />
			</c:otherwise>
		</c:choose>
	</c:if>

	<div class="cmp-wrap">
		<section class="cmp-hdr">
			<div class="cmp-hdr-inner">
				<div class="cmp-hdr-meta">
					<div class="cmp-hdr-meta-title">
						<span class="cmp-hdr-meta-brand">CyberCareerCatch</span> <span
							class="cmp-hdr-meta-name"> <c:choose>
								<c:when test="${not empty companyDetail.companyName}">
									<c:out value="${companyDetail.companyName}" />
								</c:when>
								<c:otherwise>기업명 미등록</c:otherwise>
							</c:choose>
						</span>
					</div>

					<table class="cmp-hdr-meta-tbl">
						<tr>
							<td class="cmp-hdr-meta-lbl">대표자명</td>
							<td><c:choose>
									<c:when test="${not empty companyDetail.compCeoName}">
										<c:out value="${companyDetail.compCeoName}" />
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>

							<td class="cmp-hdr-meta-lbl">설립년도</td>
							<td><c:choose>
									<c:when test="${companyDetail.compFndYear gt 0}">
										${companyDetail.compFndYear}
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>
						</tr>

						<tr>
							<td class="cmp-hdr-meta-lbl">사원 수</td>
							<td><c:choose>
									<c:when test="${companyDetail.compEmplCnt gt 0}">
										${companyDetail.compEmplCnt}명
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>

							<td class="cmp-hdr-meta-lbl">매출액</td>
							<td>
								<c:choose>
    								<c:when test="${not empty companyDetail.compRev}">
        								<c:out value="${companyDetail.compRev}" />
    								</c:when>
    								<c:otherwise>-</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</table>

					<hr class="cmp-hdr-divider" />

					<table class="cmp-hdr-meta-tbl">
						<tr>
							<td class="cmp-hdr-meta-lbl">사업자번호</td>
							<td><c:choose>
									<c:when test="${not empty companyDetail.companyBrn}">
										<c:out value="${companyDetail.companyBrn}" />
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>
						</tr>

						<tr>
							<td class="cmp-hdr-meta-lbl">기업형태</td>
							<td><c:choose>
									<c:when test="${not empty companyDetail.compType}">
										<c:out value="${companyDetail.compType}" />
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>
						</tr>

						<tr>
							<td class="cmp-hdr-meta-lbl">대표 기술</td>
							<td><c:choose>
									<c:when test="${not empty companyDetail.compTech}">
										<span style="white-space: pre-line;"><c:out
												value="${companyDetail.compTech}" /></span>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>
						</tr>

						<tr>
							<td class="cmp-hdr-meta-lbl">주요사업</td>
							<td><c:choose>
									<c:when test="${not empty companyDetail.compMainBiz}">
										<span style="white-space: pre-line;"><c:out
												value="${companyDetail.compMainBiz}" /></span>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>
						</tr>

						<tr>
							<td class="cmp-hdr-meta-lbl">회사위치</td>
							<td><c:choose>
									<c:when test="${not empty companyDetail.companyAddress}">
										<span style="white-space: pre-line;"><c:out
												value="${companyDetail.companyAddress}" /></span>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>
						</tr>
					</table>
				</div>

				<div class="cmp-hdr-logo">
					<div class="cmp-hdr-logo-img"
						<c:if test="${not empty logoSrc}">
							style="background-image:url('${logoSrc}'); background-size:cover; background-position:center; background-repeat:no-repeat;"
						</c:if>>
					</div>
				</div>
			</div>
		</section>

		<section class="cmp-sec" id="sec-info">
			<h2 class="cmp-sec-title">기업 정보</h2>
			<div class="cmp-sec-body">
				<p class="cmp-sec-sub">
					<c:choose>
						<c:when test="${not empty companyDetail.compSummary}">
							<c:out value="${companyDetail.compSummary}" />
						</c:when>
						<c:otherwise>기업 한줄 소개가 아직 등록되지 않았습니다.</c:otherwise>
					</c:choose>
				</p>

				<p style="white-space: pre-line;">
					<c:choose>
						<c:when test="${not empty companyDetail.compInfo}">
							<c:out value="${companyDetail.compInfo}" />
						</c:when>
						<c:otherwise>기업 상세 소개가 아직 등록되지 않았습니다.</c:otherwise>
					</c:choose>
				</p>

				<div class="cmp-sec-hlgt" style="white-space: pre-line;">
					<c:choose>
						<c:when test="${not empty companyDetail.compSummary}">
							<p>
								<strong><c:out value="${companyDetail.compSummary}" /></strong>
							</p>
						</c:when>
						<c:otherwise>
							<p>
								<strong>기업 한줄 소개가 아직 등록되지 않았습니다.</strong>
							</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</section>

		<section class="cmp-sec" id="sec-history">
			<h2 class="cmp-sec-title">서비스 확장 및 운영 이력</h2>
			<div class="cmp-sec-body">
				<div class="cmp-sec-hlgt" style="white-space: pre-line;">
					<c:choose>
						<c:when test="${not empty companyDetail.compSvcHist}">
							<c:out value="${companyDetail.compSvcHist}" />
						</c:when>
						<c:otherwise>서비스 확장 및 운영 이력이 아직 등록되지 않았습니다.</c:otherwise>
					</c:choose>
				</div>
			</div>
		</section>

		<section class="cmp-sec" id="sec-talent">
			<h2 class="cmp-sec-title">인재상</h2>
			<div class="cmp-sec-body">
				<div class="cmp-sec-hlgt" style="white-space: pre-line;">
					<c:choose>
						<c:when test="${not empty companyDetail.jobPostProfile}">
							<c:out value="${companyDetail.jobPostProfile}" />
						</c:when>
						<c:otherwise>인재상이 아직 등록되지 않았습니다.</c:otherwise>
					</c:choose>
				</div>
			</div>
		</section>

		<section class="cmp-sec" id="sec-recruit">
			<h2 class="cmp-sec-title">채용 부분</h2>
			<div class="cmp-sec-body">
				<div class="cmp-sec-hlgt" style="white-space: pre-line;">
					<c:choose>
						<c:when test="${not empty companyDetail.jobPostContent}">
							<c:out value="${companyDetail.jobPostContent}" />
						</c:when>
						<c:otherwise>채용 내용이 아직 등록되지 않았습니다.</c:otherwise>
					</c:choose>
				</div>
			</div>
		</section>

		<section class="cmp-sec" id="sec-process">
			<h2 class="cmp-sec-title">채용 절차</h2>
			<div class="cmp-sec-body">
				<div class="cmp-sec-hlgt" style="white-space: pre-line;">
					<c:choose>
						<c:when test="${not empty companyDetail.jobPostProcess}">
							<c:out value="${companyDetail.jobPostProcess}" />
						</c:when>
						<c:otherwise>채용 절차가 아직 등록되지 않았습니다.</c:otherwise>
					</c:choose>
				</div>
			</div>
		</section>

		<section class="cmp-sec" id="sec-apply">
			<h2 class="cmp-sec-title">지원 방법</h2>
			<div class="cmp-sec-body">
				<div class="cmp-sec-hlgt" style="white-space: pre-line;">
					<c:choose>
						<c:when test="${not empty companyDetail.jobPostMethod}">
							<c:out value="${companyDetail.jobPostMethod}" />
						</c:when>
						<c:otherwise>지원 방법이 아직 등록되지 않았습니다.</c:otherwise>
					</c:choose>
				</div>
			</div>
		</section>

		<section class="cmp-sec cmp-qna" id="sec-qna">
			<div class="cmp-qna-box" data-url="${qnaTargetUrl}"
				data-login-required="${qnaLoginRequired}">
				<p class="cmp-qna-title">기업 QnA 게시판</p>

				<c:choose>
					<c:when test="${isLoggedIn}">
						<p class="cmp-qna-sub">기업 담당자와 대화해보세요!</p>
					</c:when>
					<c:otherwise>
						<p class="cmp-qna-sub">로그인 후 이용할 수 있습니다.</p>
					</c:otherwise>
				</c:choose>
			</div>
		</section>
	</div>

	<script
		src="${pageContext.request.contextPath}/assets/js/main/company/company-info.js"></script>
	<jsp:include page="/app/main/footer/footer.jsp" />
</body>
</html>