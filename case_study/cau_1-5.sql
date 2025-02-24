#  --câu 2--
select * from nhan_vien where (ho_va_ten like 'H%'or ho_va_ten like 'T%'or ho_va_ten like 'K%')and char_length(ho_va_ten) <= 15;
# --câu 3--
select * from khach_hang where timestampdiff(year,ngay_sinh,curdate()) between 18 and 50 and (dia_chi like '% Da Nang' or dia_chi like '% Quang tri');
# --câu 4--
select kh.ma_khach_hang,kh.ho_va_ten,count(hd.ma_hop_dong)as so_lan_dat_phong from khach_hang kh
join loai_khach lk  on kh.ma_loai_khach = lk.ma_loai_khach
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where lk.ten_loai_khach = 'diamond'
group by kh.ma_khach_hang, kh.ho_va_ten
order by so_lan_dat_phong;

# --câu 5--
select kh.ma_khach_hang,kh.ho_va_ten,lk.ten_loai_khach,hd.ma_khach_hang,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
       coalesce(sum(hdct.so_luong*dvdk.gia),0) + coalesce(sum(dv.chi_phi_thue),0) as tong_tien
       from khach_hang kh
left  join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
group by kh.ma_khach_hang, kh.ho_va_ten, lk.ten_loai_khach, hd.ma_khach_hang, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc
order by tong_tien

