package io.workingtheory.playground.web.rest;

import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SerializationRequest
{
	@NotEmpty
	private List<@NotNull UUID> list;

	public List<UUID> getList()
	{
		return list;
	}

	public void setList(final List<UUID> list)
	{
		this.list = list;
	}

	@Override
	public String toString()
	{
		return "SerializationRequest{" +
			   "list=" + list +
			   '}';
	}
}
