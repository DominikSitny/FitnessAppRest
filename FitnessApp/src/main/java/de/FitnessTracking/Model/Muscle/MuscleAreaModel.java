package de.FitnessTracking.Model.Muscle;

import java.util.List;

public class MuscleAreaModel extends MuscleModel{

	List<MuscleModel> kindsList;

	@Override
	public List<MuscleModel> getKinds() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addKind(MuscleModel muscle) {
		this.kindsList.add(muscle);
	}
	public void remoteKind(MuscleModel muscle) {
		this.kindsList.remove(muscle);
	}

}
