import { FullTimeTeacher } from './fullTimeTeacher';
import { TypeEvent } from './typeEvent';
import { Campus } from './campus';
import { Career } from './career';

export class Event {
    id: number;
    dateEvent: Date;
    numberOfQuests: number;
    numberOfAttendees: number;
    comments: string;
    campus: Campus;
    career: Career;
    typeEvent: TypeEvent;
    fullTimeTeacher: FullTimeTeacher;
}