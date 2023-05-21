package actions.views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Report;

public class ReportConverter {

    public static Report toModel(ReportView rv) {
        return new Report(
                rv.getId(),
                EmployeeConverter.toModel(rv.getEmployee()),
                rv.getReportDate(),
                rv.getTitle(),
                rv.getContent(),
                rv.getCreatedAt(),
                rv.getUpdatedAt(),
                rv.getComfirmedAt(),//以下追記
                rv.getApprovedFlag() == null
                ? null
                : rv.getApprovedFlag() == AttributeConst.REP_APPROVED.getIntegerValue()
                        ? JpaConst.REP_APPROVED
                        : JpaConst.REP_NOT_APPROVED,
                rv.getPendingFlag() == null
                        ? null
                        : rv.getPendingFlag() == AttributeConst.REP_PENDING.getIntegerValue()
                                ? JpaConst.REP_PENDING
                                : JpaConst.REP_NOT_PENDING,
                rv.getDisapprovedFlag() == null
                                ? null
                                : rv.getDisapprovedFlag() == AttributeConst.REP_DISAPPROVED.getIntegerValue()
                                        ? JpaConst.REP_DISAPPROVED
                                        : JpaConst.REP_NOT_DISAPPROVED);

    }


    public static ReportView toView(Report r) {

        if (r == null) {
            return null;
        }

        return new ReportView(
                r.getId(),
                EmployeeConverter.toView(r.getEmployee()),
                r.getReportDate(),
                r.getTitle(),
                r.getContent(),
                r.getCreatedAt(),
                r.getUpdatedAt(),
                r.getComfirmedAt(),//以下追記
                r.getApproved_flag() == null
                  ? null
                  : r.getApproved_flag() == JpaConst.REP_APPROVED
                        ? AttributeConst.REP_APPROVED.getIntegerValue()
                        : AttributeConst.REP_NOT_APPROVED.getIntegerValue(),
                r.getPending_flag() == null
                        ? null
                        : r.getPending_flag() == JpaConst.REP_PENDING
                                ? AttributeConst.REP_PENDING.getIntegerValue()
                                : AttributeConst.REP_NOT_PENDING.getIntegerValue(),
                r.getDisapproved_flag() == null
                                ? null
                                : r.getDisapproved_flag() == JpaConst.REP_DISAPPROVED
                                        ? AttributeConst.REP_DISAPPROVED.getIntegerValue()
                                        : AttributeConst.REP_NOT_DISAPPROVED.getIntegerValue());
    }

    public static List<ReportView> toViewList(List<Report> list) {
        List<ReportView> evs = new ArrayList<>();

        for (Report r : list) {
            evs.add(toView(r));
        }

        return evs;
    }


    public static void copyViewToModel(Report r, ReportView rv) {
        r.setId(rv.getId());
        r.setEmployee(EmployeeConverter.toModel(rv.getEmployee()));
        r.setReportDate(rv.getReportDate());
        r.setTitle(rv.getTitle());
        r.setContent(rv.getContent());
        r.setCreatedAt(rv.getCreatedAt());
        r.setUpdatedAt(rv.getUpdatedAt());
        r.setComfirmedAt(rv.getComfirmedAt());//以下追記
        r.setApproved_flag(rv.getApprovedFlag());
        r.setPending_flag(rv.getPendingFlag());
        r.setDisapproved_flag(rv.getDisapprovedFlag());

    }

}
