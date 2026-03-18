package com.ccc.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ccc.common.config.MyBatisConfig;
import com.ccc.post.dto.NoticeDTO;
import com.ccc.post.dto.PostPageDTO;
import com.ccc.qna.dto.QnaCommentDTO;
import com.ccc.qna.dto.QnaDTO;
import com.ccc.qna.dto.QnaDetailDTO;
import com.ccc.qna.dto.QnaListDTO;
import com.ccc.qna.dto.QnaWriteDTO;

public class QnaDAO {

    private SqlSession sqlSession;


    public QnaDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    // =========================================================
    // 기업 Q&A 공지
    // =========================================================

    // 기업 Q&A 공지 목록 조회
    // mapper id : qna.selectQnaNoticeList
    public List<NoticeDTO> selectQnaNoticeList() {
        System.out.println("기업 Q&A 공지 목록 조회 - selectQnaNoticeList 실행");
        List<NoticeDTO> noticeList = sqlSession.selectList("qna.selectQnaNoticeList");
        System.out.println("조회 결과 : " + noticeList);
        return noticeList;
    }

    // 기업 Q&A 공지 상세 조회
    // parameter : postNumber
    // mapper id : qna.selectQnaNoticeDetail
    public NoticeDTO selectQnaNoticeDetail(int postNumber) {
        System.out.println("기업 Q&A 공지 상세 조회 - selectQnaNoticeDetail 실행 : " + postNumber);
        NoticeDTO noticeDTO = sqlSession.selectOne("qna.selectQnaNoticeDetail", postNumber);
        System.out.println("조회 결과 : " + noticeDTO);
        return noticeDTO;
    }

    // 기업 Q&A 공지 추가
    // mapper id : qna.insertNotice
    public void insertNotice(NoticeDTO noticeDTO) {
        System.out.println("기업 Q&A 공지 작성 - insertNotice 실행");
        int result = sqlSession.insert("qna.insertNotice", noticeDTO);
        System.out.println("공지 작성 결과 : " + result);
    }

    // 기업 Q&A 공지 삭제
    // parameter : postNumber
    // mapper id : qna.deleteNotice
    public void deleteNotice(int postNumber) {
        System.out.println("기업 Q&A 공지 삭제 - deleteNotice 실행 : " + postNumber);
        int result = sqlSession.delete("qna.deleteNotice", postNumber);
        System.out.println("공지 삭제 결과 : " + result);
    }

    // =========================================================
    // 기업 Q&A 게시글
    // =========================================================

    // 기업 Q&A 게시글 총 개수 조회
    // mapper id : qna.getTotal
    public int getTotal() {
        System.out.println("기업 Q&A 게시글 총 개수 조회 - getTotal 실행");
        return sqlSession.selectOne("qna.getTotal");
    }

    // 기업 Q&A 조회수 증가
    // 게시글 상세보기 들어가기 전에 보통 실행
    // mapper id : qna.updateReadCount
    public void updateReadCount(int postNumber) {
        System.out.println("기업 Q&A 조회수 증가 - updateReadCount 실행 : " + postNumber);
        int result = sqlSession.update("qna.updateReadCount", postNumber);
        System.out.println("조회수 증가 결과 : " + result);
    }

    // 기업 Q&A 게시글 작성
    // mapper id : qna.insert
    public void insert(QnaWriteDTO qnaWriteDTO) {
        System.out.println("기업 Q&A 게시글 작성 - insert 실행");
        int result = sqlSession.insert("qna.insert", qnaWriteDTO);
        System.out.println("게시글 작성 결과 : " + result);
    }

    // 기업 Q&A 게시글 삭제
    // postNumber + userNumber 조건으로
    // 내가 작성한 QNA_POST만 삭제
    // mapper id : qna.delete
    public void delete(QnaDTO qnaDTO) {
        System.out.println("기업 Q&A 게시글 삭제 - delete 실행");
        int result = sqlSession.delete("qna.delete", qnaDTO);
        System.out.println("게시글 삭제 결과 : " + result);
    }

    // 기업 Q&A 게시글 상세 조회
    // mapper id : qna.select
    public QnaDetailDTO select(int postNumber) {
        System.out.println("기업 Q&A 게시글 상세 조회 - select 실행 : " + postNumber);
        QnaDetailDTO qnaDetailDTO = sqlSession.selectOne("qna.select", postNumber);
        System.out.println("조회 결과 : " + qnaDetailDTO);
        return qnaDetailDTO;
    }

    // 기업 Q&A 전체 게시글 조회
    // 페이징용 DTO(page, rowCount 등)를 받아서 목록 조회
    // mapper id : qna.selectAll
    public List<QnaListDTO> selectAll(PostPageDTO postPageDTO) {
        System.out.println("기업 Q&A 전체 게시글 조회 - selectAll 실행 : " + postPageDTO);
        List<QnaListDTO> qnaList = sqlSession.selectList("qna.selectAll", postPageDTO);
        System.out.println("조회 결과 : " + qnaList);
        return qnaList;
    }

    // =========================================================
    // 기업회원 답변 댓글
    // =========================================================

    // 기업회원 답변 댓글 목록 조회
    // 특정 Q&A 게시글 번호(postNumber)에 달린 댓글 전체 조회
    // mapper id : qna.selectCommentList
    public List<QnaCommentDTO> selectCommentList(int postNumber) {
        System.out.println("기업회원 답변 댓글 목록 조회 - selectCommentList 실행 : " + postNumber);
        List<QnaCommentDTO> commentList = sqlSession.selectList("qna.selectCommentList", postNumber);
        System.out.println("조회 결과 : " + commentList);
        return commentList;
    }

    // 기업회원 답변 댓글 추가
    // mapper id : qna.insertComment
    public void insertComment(QnaCommentDTO qnaCommentDTO) {
        System.out.println("기업회원 답변 댓글 작성 - insertComment 실행");
        int result = sqlSession.insert("qna.insertComment", qnaCommentDTO);
        System.out.println("댓글 작성 결과 : " + result);
    }

    // 기업회원 답변 댓글 삭제
    // commentNumber + userNumber 조건으로
    // 내가 작성한 댓글만 삭제
    // mapper id : qna.deleteComment
    public void deleteComment(QnaCommentDTO qnaCommentDTO) {
        System.out.println("기업회원 답변 댓글 삭제 - deleteComment 실행");
        int result = sqlSession.delete("qna.deleteComment", qnaCommentDTO);
        System.out.println("댓글 삭제 결과 : " + result);
    }

    // =========================================================
    // 답변 상태 변경
    // =========================================================

    // 답변 상태를 '답변완료'로 변경
    // mapper id : qna.updateAnswerStatusComplete
    public void updateAnswerStatusComplete(int postNumber) {
        System.out.println("답변 상태 변경(답변완료) - updateAnswerStatusComplete 실행 : " + postNumber);
        int result = sqlSession.update("qna.updateAnswerStatusComplete", postNumber);
        System.out.println("답변 상태 변경 결과 : " + result);
    }

    // 답변 상태를 '답변대기'로 변경
    // mapper id : qna.updateAnswerStatusWait
    public void updateAnswerStatusWait(int postNumber) {
        System.out.println("답변 상태 변경(답변대기) - updateAnswerStatusWait 실행 : " + postNumber);
        int result = sqlSession.update("qna.updateAnswerStatusWait", postNumber);
        System.out.println("답변 상태 변경 결과 : " + result);
    }
}