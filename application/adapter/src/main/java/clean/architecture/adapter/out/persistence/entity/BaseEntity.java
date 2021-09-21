package clean.architecture.adapter.out.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @CreatedDate
    @Column(name = "created_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime updatedDate;
    @LastModifiedBy
    private Long updatedId;
    @CreatedBy
    private Long createdId;

    @Version
    private int version;
}
