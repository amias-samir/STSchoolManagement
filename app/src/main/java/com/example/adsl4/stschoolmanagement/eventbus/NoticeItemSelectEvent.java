package com.example.adsl4.stschoolmanagement.eventbus;

import com.example.adsl4.stschoolmanagement.notices.StudentNoticeModal;

public class NoticeItemSelectEvent {

    public static class NoticeItemClick{
        private StudentNoticeModal studentNoticeModal;

        public NoticeItemClick(StudentNoticeModal studentNoticeModal) {
            this.studentNoticeModal = studentNoticeModal;
        }

        public StudentNoticeModal getNoticeData() {
            return studentNoticeModal;
        }
    }
}
