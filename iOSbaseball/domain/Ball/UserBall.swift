//
//  UserBall.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/21/24.
//
enum BallCountError: Error {
    case IllegalArgumentException
}

import Foundation

class UserBall : Ball{
    private(set) var numbers : [Int] = []
    init(numbers: [Int]) throws {
        self.numbers = numbers
        
        guard hasduplication(numbers: numbers), hasZeroNumber(numbers: numbers) else {
             throw BallCountError.IllegalArgumentException
        }

    }
    
    private func hasduplication(numbers: [Int]) -> Bool {
        let uniqueNumbers = Set(numbers)
        return uniqueNumbers.count == BALL_LENGTH
    }
    
    private func hasZeroNumber(numbers : [Int]) -> Bool{
        let TargetNumber = Set(numbers)
        let CorrectNumber = Set(CORRECT_NUMBER)
        return TargetNumber.isSubset(of: CorrectNumber)
    }
    
    private let BALL_LENGTH = 3
    private let CORRECT_NUMBER = 1...9
    
}

