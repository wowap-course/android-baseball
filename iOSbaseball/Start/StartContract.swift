//
//  StartContract.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/22/24.
//

import Foundation

protocol StartView{
    func showLife(lifeCount:Int)
    func startGame(lifeCount:Int)
}

protocol StartViewPresenter {
    func increaseLifeCount()
    func decreaseLifeCount()
    func startGame()
}
