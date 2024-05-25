//
//  LifeCount.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//
enum LifeCountError: Error {
    case IllegalArgumentException
}

import Foundation

public class LifeCount{
    
    public private(set) var lifes : Int
    
    public init(lifes: Int = 1) throws {
        self.lifes = lifes
        
        guard (MIN_LIFE_COUNT...MAX_LIFE_COUNT).contains(self.lifes) else {
             throw LifeCountError.IllegalArgumentException
        }
    }
    
    public func increase() -> Bool{
        return lifes < MAX_LIFE_COUNT ? { lifes += 1; return true }() : false
    }
    
    public func decrease() -> Bool{
        return lifes > MIN_LIFE_COUNT ? { lifes -= 1; return true }() : false
    }
    
    private let MIN_LIFE_COUNT = 1
    private let MAX_LIFE_COUNT = 20
}
