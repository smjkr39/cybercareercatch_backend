document.addEventListener("DOMContentLoaded", function() {
	const form = document.getElementById("company-register-form");
	const cancelBtn = document.getElementById("cancel-btn");

	form.addEventListener("submit", function(e) {
		// 직군 체크 확인
		const checkedJobs = document.querySelectorAll('input[name="job_group"]:checked');
		if (checkedJobs.length === 0) {
			alert("직군은 최소 1개 이상 선택해야 합니다.");
			e.preventDefault();
			return;
		}

		// 각 입력칸 가져오기
		const ceoName = document.getElementById("company-ceoname");
		const companyYearFounded = document.getElementById("company-yearfounded");
		const companyEmployeeCount = document.getElementById("company-employeecount");
		const companySales = document.getElementById("company-sales");
		const companyCapital = document.getElementById("company-capital");
		const companyType = document.getElementById("company-type");
		const companyDescription = document.getElementById("company-description");
		const companyInfo = document.getElementById("company-info");
		const companyTech = document.getElementById("company-tech");
		const companyBusiness = document.getElementById("company-business");
		const companyHistory = document.getElementById("company-history");
		const companyTalent = document.getElementById("company-talent");
		const companyJobpart = document.getElementById("company-jobpart");
		const companyProcess = document.getElementById("company-process");
		const companyApply = document.getElementById("company-apply");

		// 글자수 검사
		if (ceoName.value.trim().length > 20) {
			alert("대표자명은 20자 이하로 입력해주세요.");
			ceoName.focus();
			e.preventDefault();
			return;
		}

		if (companyYearFounded.value.trim().length > 4) {
			alert("설립년도는 4자 이하로 입력해주세요.");
			companyYearFounded.focus();
			e.preventDefault();
			return;
		}

		if (companyEmployeeCount.value.trim().length > 20) {
			alert("사원수는 20자 이하로 입력해주세요.");
			companyEmployeeCount.focus();
			e.preventDefault();
			return;
		}

		if (companySales.value.trim().length > 20) {
			alert("매출액은 20자 이하로 입력해주세요.");
			companySales.focus();
			e.preventDefault();
			return;
		}

		if (companyCapital.value.trim().length > 20) {
			alert("자본금은 20자 이하로 입력해주세요.");
			companyCapital.focus();
			e.preventDefault();
			return;
		}

		if (companyType.value.trim().length > 20) {
			alert("기업형태는 20자 이하로 입력해주세요.");
			companyType.focus();
			e.preventDefault();
			return;
		}

		if (companyDescription.value.trim().length > 50) {
			alert("한줄소개는 50자 이하로 입력해주세요.");
			companyDescription.focus();
			e.preventDefault();
			return;
		}

		if (companyInfo.value.trim().length > 1000) {
			alert("기업정보는 1000자 이하로 입력해주세요.");
			companyInfo.focus();
			e.preventDefault();
			return;
		}

		if (companyTech.value.trim().length > 500) {
			alert("대표기술은 500자 이하로 입력해주세요.");
			companyTech.focus();
			e.preventDefault();
			return;
		}

		if (companyBusiness.value.trim().length > 700) {
			alert("주요사업은 700자 이하로 입력해주세요.");
			companyBusiness.focus();
			e.preventDefault();
			return;
		}

		if (companyHistory.value.trim().length > 1000) {
			alert("서비스 확장 및 운영 이력은 1000자 이하로 입력해주세요.");
			companyHistory.focus();
			e.preventDefault();
			return;
		}

		if (companyTalent.value.trim().length > 500) {
			alert("인재상은 500자 이하로 입력해주세요.");
			companyTalent.focus();
			e.preventDefault();
			return;
		}

		if (companyJobpart.value.trim().length > 1000) {
			alert("채용부분은 1000자 이하로 입력해주세요.");
			companyJobpart.focus();
			e.preventDefault();
			return;
		}

		if (companyProcess.value.trim().length > 500) {
			alert("채용 절차는 500자 이하로 입력해주세요.");
			companyProcess.focus();
			e.preventDefault();
			return;
		}

		if (companyApply.value.trim().length > 500) {
			alert("지원 정보는 500자 이하로 입력해주세요.");
			companyApply.focus();
			e.preventDefault();
			return;
		}
	});

	// 취소 버튼
	cancelBtn.addEventListener("click", function() {
		const moveUrl = cancelBtn.dataset.moveUrl;
		const isOk = confirm("입력 중인 내용이 사라집니다.\n정말 취소하시겠습니까?");

		if (isOk) {
			location.href = moveUrl;
		}
	});
});