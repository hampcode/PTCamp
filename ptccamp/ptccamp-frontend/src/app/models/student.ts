import { StudyMode } from './study-mode';
import { Career } from './career';
export class Student {
    id: number;
    code: string;
    firstName: string;
    lastName: string;
    career: Career;
    studyMode: StudyMode;
}
