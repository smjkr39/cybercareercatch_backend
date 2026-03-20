/*
 * 관리자 기업 정보페이지 목록 전용 스크립트이다.
 * 목록에서 체크 후 바로 삭제할 수 있도록 처리한다.
 */
document.addEventListener("DOMContentLoaded", function () {
    const deleteForm = document.getElementById("companyDeleteForm");

    if (!deleteForm) {
        return;
    }

    deleteForm.addEventListener("submit", function (event) {
        const checkedList = deleteForm.querySelectorAll("input[name='companyNumber']:checked");

        if (checkedList.length === 0) {
            alert("삭제할 기업 정보페이지를 선택하세요.");
            event.preventDefault();
            return;
        }

        const isConfirmed = confirm("선택한 기업 정보페이지를 삭제하시겠습니까?");

        if (!isConfirmed) {
            event.preventDefault();
        }
    });
});