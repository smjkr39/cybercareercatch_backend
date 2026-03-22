<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
    if (request.getAttribute("mainQuestion") == null
            || request.getAttribute("mainCurrentQuestionNumber") == null
            || request.getAttribute("mainQuestionCount") == null) {
        response.sendRedirect(request.getContextPath() + "/mainpage/mainpage.mafc");
        return;
    }
%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>메인페이지</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main/mainpage/mainpage-login.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/main/mainpage/mainpage-login.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.19/index.global.min.js"></script>

  <style>
    .mainpage-community-calendarcard {
      background-color: #ffffff !important;
    }

    .expo-preview-wrap-force {
      display: flex !important;
      flex-direction: column !important;
      gap: 0 !important;
      margin-top: 14px !important;
      width: 100% !important;
      border-top: 1px solid rgba(0, 0, 0, 0.08) !important;
    }

    .expo-preview-card-force {
      display: block !important;
      width: 100% !important;
      padding: 18px 8px !important 18px 0 !important;
      cursor: pointer !important;
      transition: background-color 0.2s ease !important;
      border-bottom: 1px solid rgba(0, 0, 0, 0.08) !important;
    }

    .expo-preview-card-force:hover {
      background-color: rgba(78, 119, 255, 0.03) !important;
    }

    .expo-preview-title-force {
      font-size: 17px !important;
      font-weight: 800 !important;
      color: #111111 !important;
      line-height: 1.4 !important;
      margin-bottom: 11px !important;
      word-break: keep-all !important;
    }

    .expo-preview-info-force {
      display: flex !important;
      flex-direction: column !important;
      gap: 8px !important;
    }

    .expo-preview-row-force {
      display: flex !important;
      align-items: flex-start !important;
      gap: 10px !important;
      flex-wrap: wrap !important;
    }

    .expo-preview-badge-force {
      display: inline-flex !important;
      align-items: center !important;
      justify-content: center !important;
      min-width: 44px !important;
      padding: 4px 10px !important;
      border-radius: 999px !important;
      background-color: rgba(78, 119, 255, 0.12) !important;
      color: #4E77FF !important;
      font-size: 13px !important;
      font-weight: 700 !important;
      flex-shrink: 0 !important;
    }

    .expo-preview-text-force {
      font-size: 15px !important;
      color: rgba(0, 0, 0, 0.76) !important;
      line-height: 1.6 !important;
      text-decoration: none !important;
      word-break: keep-all !important;
    }

    .expo-preview-empty-force {
      padding: 26px 14px !important;
      border-radius: 14px !important;
      background-color: rgba(78, 119, 255, 0.04) !important;
      border: 1px dashed rgba(78, 119, 255, 0.2) !important;
      font-size: 15px !important;
      color: rgba(0, 0, 0, 0.45) !important;
      text-align: center !important;
      margin-top: 14px !important;
    }
  </style>
</head>

<body>
  <c:set var="defaultCompanyImg" value="${pageContext.request.contextPath}/assets/img/기업이미지_샘플1.jpg" />

  <div class="mainpage-main-container"
       data-reset-url="${pageContext.request.contextPath}/mainpage/mainpageAnswerReset.mafc"
       data-test-in-progress="${mainIsTestInProgress}">

    <div class="mainpage-section-searchjob">
      <div class="mainpage-searchjob-title">
        "CyberCarrerCatch에서 자신에게 맞는<br>
        적성분야를 찾고, 당신의 커리어를 주도하세요."
      </div>

      <div style="font-size:14px; color:#4E77FF; text-align:center; font-weight:600; background:rgba(78, 119, 255, 0.08); padding:10px 16px; border-radius:999px;">
        질문에 대한 답변은 회원만 받아 볼 수 있습니다.
      </div>

      <div class="mainpage-searchjob-question" id="question">
        <c:choose>
          <c:when test="${not empty mainQuestion}">
            Q${mainQuestion.jobQuestionNumber}. <c:out value="${mainQuestion.jobQuestionContent}" />
          </c:when>
          <c:otherwise>
            Q1. 당신에게 맞는 직군을 탐색해보세요.
          </c:otherwise>
        </c:choose>
      </div>

      <form id="mainQuestionForm"
            action="${pageContext.request.contextPath}/mainpage/mainpageAnswerOk.mafc"
            method="post"
            autocomplete="off">

        <input type="hidden"
               name="currentQuestionNumber"
               value="${empty mainCurrentQuestionNumber ? 1 : mainCurrentQuestionNumber}">

        <button type="submit" id="mainpage-hidden-submit" style="display:none;"></button>

        <div class="mainpage-searchjob-searchbar">
          <input type="text"
                 name="answer"
                 id="mainpage-searchjob-answer"
                 placeholder="답변을 입력해주세요"
                 maxlength="4000">
          <img src="${pageContext.request.contextPath}/assets/img/검색돋보기.png"
               alt="검색"
               id="searchimg">
        </div>
      </form>
    </div>

    <div class="mainpage-section-jobcategory">
      <div class="mainpage-section-title">추천 직군 유형</div>

      <div class="mainpage-jobcategory-cards">
        <a href="${pageContext.request.contextPath}/roadmap/detail.rfc?jobNumber=1" class="mainpage-jobcategory-card">
          <div class="mainpage-jobcategory-cardtitle">
            <img class="jobcategory-cardtitle-img" src="${pageContext.request.contextPath}/assets/img/보안컨설팅 계열 직군 마크.png" alt="">
            <div class="mainpage-jobcategory-cardtitletext">보안컨설팅</div>
          </div>
          <div class="mainpage-jobcategory-cardcontent">
            고객의 요청 대상에 취약점 진단 컨설팅을 수행하여 최신의 해킹 및 침해 형태 변화에 따른 대응을 강화하고,
            지속적으로 최상의 보안 상태를 유지 및 관리할 수 있도록 진단 컨설팅을 제공
          </div>
          <div class="mainpage-jobcategory-cardbottom">
            <div class="mainpage-jobcategory-cardbottomtext">관련직군소개</div>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/roadmap/detail.rfc?jobNumber=2" class="mainpage-jobcategory-card">
          <div class="mainpage-jobcategory-cardtitle">
            <img class="jobcategory-cardtitle-img" src="${pageContext.request.contextPath}/assets/img/시스템 네트워크 엔지니어 마크.png" alt="">
            <div class="mainpage-jobcategory-cardtitletext">시스템/네트워크/엔지니어</div>
          </div>
          <div class="mainpage-jobcategory-cardcontent">
            보안 시스템을 설계하고 구축하며, 개발과 인프라 환경에 보안을 적용하는 계열
          </div>
          <div class="mainpage-jobcategory-cardbottom">
            <div class="mainpage-jobcategory-cardbottomtext">관련직군소개</div>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/roadmap/detail.rfc?jobNumber=3" class="mainpage-jobcategory-card">
          <div class="mainpage-jobcategory-cardtitle">
            <img class="jobcategory-cardtitle-img" src="${pageContext.request.contextPath}/assets/img/보안관제.png" alt="">
            <div class="mainpage-jobcategory-cardtitletext">보안관제</div>
          </div>
          <div class="mainpage-jobcategory-cardcontent">
            조직의 정보 자산 보호를 위한 24시간 365일 사이버 위협 대응 및 사전 예방을 담당하는 계열
          </div>
          <div class="mainpage-jobcategory-cardbottom">
            <div class="mainpage-jobcategory-cardbottomtext">관련직군소개</div>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/roadmap/detail.rfc?jobNumber=4" class="mainpage-jobcategory-card">
          <div class="mainpage-jobcategory-cardtitle">
            <img class="jobcategory-cardtitle-img" src="${pageContext.request.contextPath}/assets/img/침해 사고 디지털 포렌식.png" alt="">
            <div class="mainpage-jobcategory-cardtitletext">침해사고 포렌식</div>
          </div>
          <div class="mainpage-jobcategory-cardcontent">
            해킹 악성코드 등 정보시스템 침해 시 원인과 경로를 규명하고 증거의 무결성을 확보하여 분석하는 분야
          </div>
          <div class="mainpage-jobcategory-cardbottom">
            <div class="mainpage-jobcategory-cardbottomtext">관련직군소개</div>
          </div>
        </a>
      </div>
    </div>

    <div class="mainpage-section-companyad">
      <div class="mainpage-section-titlebox">
        <div class="mainpage-section-title">기업 홍보</div>
        <a id="mainpage-companyad-more-link"
           href="${pageContext.request.contextPath}/company/companyAd.cfc">
          <img id="showmore" src="${pageContext.request.contextPath}/assets/img/showmore.png" alt="더보기">
        </a>
      </div>

      <div class="mainpage-companyad-companycards">
        <c:choose>
          <c:when test="${not empty mainCompanyList}">
            <c:forEach var="company" items="${mainCompanyList}">
              <c:set var="companyImgSrc" value="${defaultCompanyImg}" />

              <c:if test="${not empty company.filePath}">
                <c:choose>
                  <c:when test="${fn:startsWith(company.filePath, 'http://') or fn:startsWith(company.filePath, 'https://')}">
                    <c:set var="companyImgSrc" value="${company.filePath}" />
                  </c:when>
                  <c:when test="${fn:startsWith(company.filePath, '/')}">
                    <c:set var="companyImgSrc" value="${pageContext.request.contextPath}${company.filePath}" />
                  </c:when>
                  <c:otherwise>
                    <c:set var="companyImgSrc" value="${pageContext.request.contextPath}/${company.filePath}" />
                  </c:otherwise>
                </c:choose>
              </c:if>

              <a href="${pageContext.request.contextPath}/company/companyInfo.cfc?companyNumber=${company.companyNumber}" class="mainpage-companyad-companycard">
                <img src="${companyImgSrc}"
                     alt="<c:out value='${company.companyName}'/>"
                     class="mainpage-companyad-companyimg"
                     onerror="this.src='${defaultCompanyImg}'">

                <div class="mainpage-companyad-companycardtext">
                  <div class="mainpage-companyad-companyname">
                    <c:out value="${company.companyName}" />
                  </div>

                  <div class="mainpage-companyad-companysummary">
                    <c:choose>
                      <c:when test="${not empty company.compSummary}">
                        <c:out value="${company.compSummary}" />
                      </c:when>
                      <c:otherwise>기업 한줄 소개가 아직 등록되지 않았습니다.</c:otherwise>
                    </c:choose>
                  </div>

                  <div class="mainpage-companyad-companyaddress">
                    <c:choose>
                      <c:when test="${not empty company.companyAddress}">
                        <c:out value="${company.companyAddress}" />
                      </c:when>
                      <c:otherwise>-</c:otherwise>
                    </c:choose>
                  </div>
                </div>
              </a>
            </c:forEach>
          </c:when>

          <c:otherwise>
            <div class="mainpage-companyad-companycard">
              <img src="${defaultCompanyImg}" alt="기본 이미지" class="mainpage-companyad-companyimg">
              <div class="mainpage-companyad-companycardtext">
                <div class="mainpage-companyad-companyname">기업 정보 준비중</div>
                <div class="mainpage-companyad-companysummary">노출 가능한 기업 홍보 정보가 아직 없습니다.</div>
                <div class="mainpage-companyad-companyaddress">-</div>
              </div>
            </div>
          </c:otherwise>
        </c:choose>
      </div>
    </div>

    <div class="mainpage-section-community">
      <div class="mainpage-section-title">커뮤니티</div>

      <div class="mainpage-community-cards">
        <a href="${pageContext.request.contextPath}/post/list.pfc" class="mainpage-community-card">
          <div class="mainpage-community-cardtop">
            <div class="mainpage-community-cardlabel">FREE</div>
          </div>

          <div class="mainpage-community-cardmiddle">
            <div class="mainpage-community-cardtitle">자유게시판</div>
            <div class="mainpage-community-cardcontent">
              회원들이 자유롭게 이야기를 나누는 공간입니다.
              취업 준비, 프로젝트, 공부, 일상 이야기를 편하게 공유해보세요.
            </div>
          </div>

          <div class="mainpage-community-cardbottom">
            <div class="mainpage-community-cardbottomtext">게시판 바로가기</div>
            <div class="mainpage-community-cardarrow">→</div>
          </div>
        </a>

        <a href="${pageContext.request.contextPath}/qna/list.qfc" class="mainpage-community-card">
          <div class="mainpage-community-cardtop">
            <div class="mainpage-community-cardlabel">Q&A</div>
          </div>

          <div class="mainpage-community-cardmiddle">
            <div class="mainpage-community-cardtitle">기업 Q&amp;A</div>
            <div class="mainpage-community-cardcontent">
              기업에게 궁금한 점을 질문하고 답변을 확인할 수 있습니다.
              직무, 채용 절차, 기업 문화에 대해 직접 물어보세요.
            </div>
          </div>

          <div class="mainpage-community-cardbottom">
            <div class="mainpage-community-cardbottomtext">Q&amp;A 바로가기</div>
            <div class="mainpage-community-cardarrow">→</div>
          </div>
        </a>

        <div class="mainpage-community-calendarcard">
          <div class="mainpage-community-calendarhead">
            <div>
              <div class="mainpage-community-calendartitle">박람회 일정</div>
              <div class="mainpage-community-calendardesc">등록 최신순 박람회 3개를 확인해보세요.</div>
            </div>
            <a href="${pageContext.request.contextPath}/expo/calendar.ex" class="mainpage-community-calendarlink">전체보기</a>
          </div>

          <div class="expo-preview-wrap-force">
            <c:choose>
              <c:when test="${not empty mainExpoList}">
                <c:forEach var="expo" items="${mainExpoList}">
                  <div class="expo-preview-card-force"
                       onclick="location.href='${pageContext.request.contextPath}/expo/calendar.ex'">

                    <div class="expo-preview-title-force">
                      <c:out value="${expo.expoName}" />
                    </div>

                    <div class="expo-preview-info-force">
                      <div class="expo-preview-row-force">
                        <span class="expo-preview-badge-force">일정</span>
                        <span class="expo-preview-text-force">
                          <c:out value="${expo.startDate}" /> ~ <c:out value="${expo.endDate}" />
                        </span>
                      </div>

                      <div class="expo-preview-row-force">
                        <span class="expo-preview-badge-force">장소</span>
                        <span class="expo-preview-text-force">
                          <c:out value="${expo.location}" />
                        </span>
                      </div>
                    </div>

                  </div>
                </c:forEach>
              </c:when>

              <c:otherwise>
                <div class="expo-preview-empty-force">
                  현재 등록된 박람회 일정이 없습니다.
                </div>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
    </div>
  </div>

  <c:if test="${not empty mainAlertMessage}">
    <script>
      window.addEventListener("load", function () {
        alert("${mainAlertMessage}");
      });
    </script>
  </c:if>
</body>

</html>