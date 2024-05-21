//
//  ViewController.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//

import UIKit

class MainViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        let backButton = UIBarButtonItem(title: "", style: .plain, target: self, action: #selector(backButtonTapped))
        backButton.image = UIImage(systemName: "chevron.left") // iOS 기본 chevron 이미지를 사용
        navigationItem.leftBarButtonItem = backButton
    }

    @objc func backButtonTapped() {
        dismiss(animated: true, completion: nil)
    }
}

