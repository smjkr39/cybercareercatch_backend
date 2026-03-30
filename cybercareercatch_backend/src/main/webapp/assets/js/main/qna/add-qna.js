/*
기업 QnA 글쓰기 페이지 스크립트

역할
1. 제목/내용 길이 검증
2. 등록 전 확인창 띄우기
*/
document.addEventListener("DOMContentLoaded", () => {
	const qnaWriteForm = document.getElementById("qnaWriteForm");
	const titleInput = document.getElementById("postTitle");       // ← 추가
	const contentInput = document.getElementById("postContent");   // ← 추가
	const titleCount = document.getElementById("titleCount");      // ← 추가
	const contentCount = document.getElementById("contentCount");  // ← 추가
	const submitBtn = document.querySelector(".cmw-btn");          // ← 추가

	const TITLE_MIN = 10;
	const TITLE_MAX = 100;
	const CONTENT_MIN = 10;
	const CONTENT_MAX = 1000;
	
	let titleAlertShown = false;
	let contentAlertShown = false;

	function updateCount() {
		if (titleInput && titleCount) {
			titleCount.textContent = `${titleInput.value.length} / ${TITLE_MAX}`;
		}
		if (contentInput && contentCount) {
			contentCount.textContent = `${contentInput.value.length} / ${CONTENT_MAX}`;
		}
	}

	function limitInput(input, max, type) {
		if (!input) return;
		if (input.value.length > max) {
			input.value = input.value.substring(0, max);
			if (type === "title" && !titleAlertShown) {
				alert(`제목은 더이상 입력할 수 없습니다. 최대 ${TITLE_MAX}자까지 입력 가능합니다.`);
				titleAlertShown = true;
			}
			if (type === "content" && !contentAlertShown) {
				alert(`내용은 더이상 입력할 수 없습니다. 최대 ${CONTENT_MAX}자까지 입력 가능합니다.`);
				contentAlertShown = true;
			}
		} else {
			if (type === "title") titleAlertShown = false;
			if (type === "content") contentAlertShown = false;
		}
	}

	if (titleInput) {
		titleInput.addEventListener("input", () => {
			limitInput(titleInput, TITLE_MAX, "title");
			updateCount();
		});
	}

	if (contentInput) {
		contentInput.addEventListener("input", () => {
			limitInput(contentInput, CONTENT_MAX, "content");
			updateCount();
		});
	}

	if (qnaWriteForm) {
		qnaWriteForm.addEventListener("submit", function(e) {
			const companyNumber = document.getElementById("companyNumber").value;
			const postTitle = document.getElementById("postTitle").value.trim();
			const postContentElement = document.getElementById("postContent");
			const postContent = postContentElement.value;        // 공백 포함 길이 체크용
			const postContentTrimmed = postContentElement.value.trim(); // 공백만 입력 방지용

			if (!companyNumber) {
				alert("기업을 선택해주세요.");
				e.preventDefault();
				return;
			}

			if (postTitle.length < 10 || postTitle.length > 100) {
				alert("제목은 10자 이상 100자 이하로 입력해주세요.");
				return;
			}

			// 내용은 공백 포함 10자 이상 1000자 이하
			if (postContentTrimmed.length === 0 || postContent.length < 10 || postContent.length > 1000) {
				alert("내용은 공백 포함 10자 이상 1000자 이하로 입력해주세요.");
				e.preventDefault();
				return;
			}

			const ok = confirm("글을 생성하겠습니까?");
			if (!ok) {
				e.preventDefault();
				return;
			}
			if (submitBtn) {
				submitBtn.disabled = true;
				submitBtn.textContent = "등록 중...";
			}

		});
	}
	updateCount();
});