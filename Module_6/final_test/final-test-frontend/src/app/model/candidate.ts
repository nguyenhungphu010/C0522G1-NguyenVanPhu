import {CandidateType} from './candidate-type';
import {InterviewRecord} from './interview-record';

export interface Candidate {
  id?: number;
  name?: string;
  dayOfBirth?: string;
  phoneNumber?: string;
  experiencedYear?: number;
  specialist?: string;
  graduatedYear?: string;
  graduatedResult?: string;
  graduatedSchool?: string;
  major?: string;
  currentSemester?: number;
  candidateType?: CandidateType;
  interviewRecord?: InterviewRecord;
}
