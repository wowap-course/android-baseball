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
        
        guard hasduplication(numbers: numbers), hasCorrectNumber(numbers: numbers), hasCollectLength(numbers: numbers) else {
             throw BallCountError.IllegalArgumentException
        }

    }
    
    private func hasduplication(numbers: [Int]) -> Bool {
        let uniqueNumbers = Set(numbers)
        return uniqueNumbers.count == BALL_LENGTH
    }
    
    private func hasCorrectNumber(numbers : [Int]) -> Bool{
        let TargetNumber = Set(numbers)
        let CorrectNumber = Set(CORRECT_NUMBER)
        return TargetNumber.isSubset(of: CorrectNumber)
    }
    
    private func hasCollectLength(numbers : [Int]) -> Bool{
        return numbers.count == BALL_LENGTH
    }
    
    private let BALL_LENGTH = 3
    private let CORRECT_NUMBER = 1...9
    
}
