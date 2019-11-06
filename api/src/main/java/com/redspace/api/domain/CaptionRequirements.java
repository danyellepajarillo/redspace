package com.redspace.api.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A CaptionRequirements.
 */
@Entity
@Table(name = "caption_requirements")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CaptionRequirements implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "framerate")
    private String framerate;

    @Column(name = "drop_frame")
    private Boolean dropFrame;

    @Column(name = "material_template")
    private String materialTemplate;

    @ManyToOne
    private CaptionFormat captionFormat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public CaptionRequirements name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFramerate() {
        return framerate;
    }

    public CaptionRequirements framerate(String framerate) {
        this.framerate = framerate;
        return this;
    }

    public void setFramerate(String framerate) {
        this.framerate = framerate;
    }

    public Boolean isDropFrame() {
        return dropFrame;
    }

    public CaptionRequirements dropFrame(Boolean dropFrame) {
        this.dropFrame = dropFrame;
        return this;
    }

    public void setDropFrame(Boolean dropFrame) {
        this.dropFrame = dropFrame;
    }

    public String getMaterialTemplate() {
        return materialTemplate;
    }

    public void setMaterialTemplate(String materialTemplate) {
        this.materialTemplate = materialTemplate;
    }

    public CaptionFormat getCaptionFormat() {
        return captionFormat;
    }

    public CaptionRequirements captionFormat(CaptionFormat captionFormat) {
        this.captionFormat = captionFormat;
        return this;
    }

    public void setCaptionFormat(CaptionFormat captionFormat) {
        this.captionFormat = captionFormat;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CaptionRequirements captionRequirements = (CaptionRequirements) o;
        if (captionRequirements.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), captionRequirements.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CaptionRequirements{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", framerate='" + getFramerate() + "'" +
            ", dropFrame='" + isDropFrame() + "'" +
            ", materialTemplate='" + getMaterialTemplate() + "'" +
            "}";
    }
}