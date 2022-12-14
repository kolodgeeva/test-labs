package com.example.testlabs.service.lab6.device;

import com.example.testlabs.service.lab6.user.UserLab6;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "device_lab_6")
public class Device {
    @Id
    private String id;
    private DeviceType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserLab6 owner;
}
