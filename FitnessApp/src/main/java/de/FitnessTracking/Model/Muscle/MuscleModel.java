package de.FitnessTracking.Model.Muscle;

import java.util.List;

public abstract class MuscleModel {
	
	private String name;
	private String info;

	public abstract List<MuscleModel> getKinds();
	
	public List<MuscleModel> getMuscleModelFromDB() {
		return null;
	}
	
	public void saveMuscleModelToDB() {
	}
	
	
	
}
