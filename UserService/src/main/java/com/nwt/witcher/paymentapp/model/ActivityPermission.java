package com.nwt.witcher.paymentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activities_permissions")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ActivityPermission {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer activityPermissionId;

	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Permission.class)
	@JoinColumn(name = "permission_id")
	private Permission permission;

	@Column(name = "permission_id", insertable = false, updatable = false)
	private Integer permissionId;

	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Activity.class)
	@JoinColumn(name = "activity_id")
	private Activity activity;

	@Column(name = "activity_id", insertable = false, updatable = false)
	private Integer activityId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	public ActivityPermission(){

	}

	public Integer getActivityPermissionId() {
		return activityPermissionId;
	}

	public void setActivityPermissionId(Integer activityPermissionId) {
		this.activityPermissionId = activityPermissionId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
