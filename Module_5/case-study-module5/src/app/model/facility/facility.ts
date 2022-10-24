import {FacilityType} from "./FacilityType";
import {RentType} from "./rent-type";

export interface Facility {
  id?: number;
  name?: string;
  area?: number;
  cost?: number;
  maxPeople?: number;
  rentType?: RentType;
  facilityType?:FacilityType;
  standardRoom?: string;
  convenience?: string;
  poolArea?: number;
  floors?: number;
  facilityFree?: string;
}

