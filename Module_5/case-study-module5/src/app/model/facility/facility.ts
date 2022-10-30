import {FacilityType} from "./FacilityType";
import {RentType} from "./rent-type";

export interface Facility {
  id?: number;
  facilityName?: string;
  facilityArea?: number;
  facilityCost?: number;
  maxPeople?: number;
  rentType?: RentType;
  facilityType?:FacilityType;
  standardRoom?: string;
  descriptionOtherConvenience?: string;
  poolArea?: number;
  numberOfFloors?: number;
  facilityFree?: string;
}

