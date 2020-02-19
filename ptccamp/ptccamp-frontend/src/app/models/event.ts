import { TypeEvent } from './type-event';
import { FullTimeTeacher } from './full-time-teacher';
import { Career } from './career';
import { Campus } from './campus';
export class Event {
    id:number;
    dateEvent:string;
    comments:string;
    numberOfQuests:number;
    numberOfAttendees:number;
    career:Career;
    campus:Campus;
    fullTimeTeacher:FullTimeTeacher;
    typeEvent:TypeEvent;
}
