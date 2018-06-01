package Mapper;

import java.util.List;

import domain.Deprecollect;

public interface DeprecollectMapper {

	List<Deprecollect> SelectBydepre(Deprecollect record);
	
	int Insertdepreselective(Deprecollect record);
}
