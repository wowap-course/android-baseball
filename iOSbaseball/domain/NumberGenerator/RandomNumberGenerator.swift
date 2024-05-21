//
//  RandomNumberGenerator.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/21/24.
//

import Foundation

class RandomNumberGenerator : NumberGenerator{
    
    func getNumbers() -> [Int] {
        let nums = Array(MIN_RANDOM_NUM...MAX_RANDOM_NUM)
        return Array(nums.shuffled().prefix(RANDOM_NUM_LENGTH))
    }
    
    private let MIN_RANDOM_NUM = 1
    private let MAX_RANDOM_NUM = 9
    private let RANDOM_NUM_LENGTH = 3
    
}
