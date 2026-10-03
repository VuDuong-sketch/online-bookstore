export default function Login() {
  return (
    <div className="h-screen flex flex-row justify-center items-center">
      <div className="w-auto h-auto border rounded-lg flex flex-col justify-between p-[10px]">
        <input className="w-[500px] h-[50px] border rounded-lg m-[10px] outline-none" type="text" placeholder="username" />
        <input className="w-[500px] h-[50px] border rounded-lg m-[10px] outline-none" type="password" placeholder="password" />
        <div className="w-[500px] h-[50px] border rounded-lg m-[10px] flex justify-center items-center cursor-pointer hover:bg-gray-100">
          Đăng nhập
        </div>
        <div className="w-[500px] h-[50px] border rounded-lg m-[10px] flex justify-center items-center cursor-pointer hover:bg-gray-100">
          Bạn chưa có tài khoản?
        </div>
      </div>
    </div>
  );
}