package com.chpark.shop.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 11/08/2020
 * Time : 12:31 AM
 */

@Getter
@AllArgsConstructor
@Embeddable
public class MemberId {
    @Column(name = "member_id")
    private String id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MemberId memberId = (MemberId) obj;
        return Objects.equals(this.id, memberId.getId());
    }
}
