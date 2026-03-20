document.addEventListener("DOMContentLoaded", function () {

    const roadmapForm = document.getElementById("roadmapForm");
    const resetBtn = document.getElementById("roadmapResetBtn");
    const textareas = document.querySelectorAll(".rm-textarea");

    /*
     * textarea 높이를 내용에 맞게 늘려준다.
     */
    function resizeTextarea(textarea) {
        textarea.style.height = "auto";
        textarea.style.height = textarea.scrollHeight + "px";
    }

    textareas.forEach(function (textarea) {
        resizeTextarea(textarea);

        textarea.addEventListener("input", function () {
            resizeTextarea(textarea);
        });
    });

    /*
     * 수정 버튼 제출 전에 한 번 더 확인한다.
     */
    if (roadmapForm) {
        roadmapForm.addEventListener("submit", function (e) {
            const isOk = confirm("로드맵 내용을 수정하시겠습니까?");

            if (!isOk) {
                e.preventDefault();
            }
        });
    }

    /*
     * 취소 버튼은 reset 전에 확인창을 띄운다.
     */
    if (resetBtn) {
        resetBtn.addEventListener("click", function (e) {
            const isOk = confirm("입력한 내용을 초기화하시겠습니까?");

            if (!isOk) {
                e.preventDefault();
            }
        });
    }
});