package model.jenkins;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.EntityBase;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name = "computer")
public class Computer extends EntityBase
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = JenkinsServer.class)
	@JoinColumn(name = "jenkinsServer_id", nullable = false, updatable = true, insertable = true)
	private JenkinsServer jenkinsServer;

	private String assignedLabels;

	private boolean watch;

	private boolean stickyWatch;

	private boolean offline;

	private String offlineCause;

	private Double diskSpaceLeft;

	@Override
	protected void setId(final Long id)
	{
		this.id = id;
	}

	@Override
	public Long getId()
	{
		return id;
	}

	@JsonIgnore
	public JenkinsServer getJenkinsServer()
	{
		return jenkinsServer;
	}

	@JsonIgnore
	public void setJenkinsServer(final JenkinsServer jenkinsServer)
	{
		this.jenkinsServer = jenkinsServer;
	}

	public String getAssignedLabels()
	{
		return assignedLabels;
	}

	public void setAssignedLabels(final String assignedLabels)
	{
		this.assignedLabels = assignedLabels;
	}

	public boolean isWatch()
	{
		return watch;
	}

	public void setWatch(final boolean watch)
	{
		this.watch = watch;
	}

	public boolean isStickyWatch()
	{
		return stickyWatch;
	}

	public void setStickyWatch(final boolean stickyWatch)
	{
		this.stickyWatch = stickyWatch;
	}

	public boolean isOffline()
	{
		return offline;
	}

	public void setOffline(final boolean offline)
	{
		this.offline = offline;
	}

	public String getOfflineCause()
	{
		return offlineCause;
	}

	public void setOfflineCause(final String offlineCause)
	{
		this.offlineCause = offlineCause;
	}

	public Double getDiskSpaceLeft()
	{
		return diskSpaceLeft;
	}

	public void setDiskSpaceLeft(final Double diskSpaceLeft)
	{
		this.diskSpaceLeft = diskSpaceLeft;
	}
}