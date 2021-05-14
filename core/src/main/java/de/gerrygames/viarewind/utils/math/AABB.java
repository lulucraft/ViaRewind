package de.gerrygames.viarewind.utils.math;

import lombok.Getter;

public class AABB {
	@Getter
	private Vector3d min;
	@Getter
	private Vector3d max;

	public AABB(Vector3d min, Vector3d max) {
		this.min = min;
		this.max = max;
	}

	public Vector3d getMin() {
		return min;
	}

	public void setMin(Vector3d min) {
		this.min = min;
	}

	public Vector3d getMax() {
		return max;
	}

	public void setMax(Vector3d max) {
		this.max = max;
	}
}
