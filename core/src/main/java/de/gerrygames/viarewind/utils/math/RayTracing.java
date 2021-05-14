package de.gerrygames.viarewind.utils.math;

public class RayTracing {

	public static Vector3d trace(Ray3d ray, AABB aabb, double distance) {
		Vector3d invDir = new Vector3d(1f / ray.dir.getX(), 1f / ray.dir.getY(), 1f / ray.dir.getZ());

		boolean signDirX = invDir.getX() < 0;
		boolean signDirY = invDir.getY() < 0;
		boolean signDirZ = invDir.getZ() < 0;

		Vector3d bbox = signDirX ? aabb.getMax() : aabb.getMin();
		double tmin = (bbox.getX() - ray.start.getX()) * invDir.getX();
		bbox = signDirX ? aabb.getMin() : aabb.getMax();
		double tmax = (bbox.getX() - ray.start.getX()) * invDir.getX();
		bbox = signDirY ? aabb.getMax() : aabb.getMin();
		double tymin = (bbox.getY() - ray.start.getY()) * invDir.getY();
		bbox = signDirY ? aabb.getMin() : aabb.getMax();
		double tymax = (bbox.getY() - ray.start.getY()) * invDir.getY();

		if (tmin > tymax || tymin > tmax) return null;

		if (tymin > tmin) tmin = tymin;

		if (tymax < tmax) tmax = tymax;

		bbox = signDirZ ? aabb.getMax() : aabb.getMin();
		double tzmin = (bbox.getZ() - ray.start.getZ()) * invDir.getZ();
		bbox = signDirZ ? aabb.getMin() : aabb.getMax();
		double tzmax = (bbox.getZ() - ray.start.getZ()) * invDir.getZ();

		if (tmin > tzmax || tzmin > tmax) return null;

		if (tzmin > tmin) tmin = tzmin;

		if (tzmax < tmax) tmax = tzmax;

		return tmin <= distance && tmax > 0 ? ray.start.clone().add(ray.dir.clone().normalize().multiply(tmin)) : null;
	}

}
