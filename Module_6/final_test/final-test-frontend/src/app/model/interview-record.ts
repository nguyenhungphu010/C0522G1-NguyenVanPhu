import {CandidateType} from './candidate-type';
import {InterviewResult} from './interview-result';

export interface InterviewRecord {

  id?: number;
  interviewTime?: string;
  interviewer?: string;
  counts?: number;
  comment?: string;
  salary?: number;
  interviewResult?: InterviewResult;
}
