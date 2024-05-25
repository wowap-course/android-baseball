//
//  Referee.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/21/24.
//

import Foundation

public class Referee{
    
    public init() { }
    
    public func getGameScore(baseNumbers: [Int], targetNumbers: [Int]) -> Score{
        return Score(ball: getBallCount(baseNumbers: baseNumbers, targetNumbers: targetNumbers), strike: getStrikeCount(baseNumbers: baseNumbers, targetNumbers: targetNumbers))
    }
    
    public func getBallCount(baseNumbers: [Int], targetNumbers: [Int]) -> Int {
        return baseNumbers.filter { num in
            targetNumbers.contains(num) && num != targetNumbers[baseNumbers.firstIndex(of: num)!]
        }.count
    }
    
    public func getStrikeCount(baseNumbers: [Int], targetNumbers: [Int]) -> Int {
        return baseNumbers.enumerated().filter { $0.element == targetNumbers[$0.offset] }.count
    }
    
}
